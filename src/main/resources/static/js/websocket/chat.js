//FIXME 소켓참고용
(function() {
    "use strict";
    var chat = {
        stompClient : null,
        socket : null,
        connect: function(){
            var _self = this;
            // if(!_self.socket){
                _self.socket = new SockJS('/ws');
                _self.stompClient = Stomp.over(_self.socket);
                _self.stompClient.connect({}, onConnected, onError);
            // }

            //소켓 정상 연결된 후
            function onConnected(){
                toastr.info('subscribe -> /topic/'+MAP_TYPE+'/'+MAP_ID,'',{timeOut:2000});
                _self.stompClient.subscribe('/topic/'+MAP_TYPE+'/'+MAP_ID, _self.onMessageReceived); //연결되면 수신시 받을 함수와 매핑
            }
            //소켓 연결 에러 시
            function onError(){
                console.log("onError");
                _self.socket = null;
            }
        },
        onMessageReceived: function(payload){
            let _self = this;
            let message = JSON.parse(payload.body);
            console.log(message);
            if(message.messageType === "TEST"){
                saama.core.pane.objArr.add({position:message.position.split(",")});
                saama.core.pane.resetPane();
            }else if(message.messageType === "CHAT"){
                for (let i = 0; i < saama.core.pane.objArr.length(); i++) {
                    if(saama.core.pane.objArr.get(i).sender === message.sender){
                        saama.core.pane.objArr.get(i).message = message.message
                        saama.core.pane.objArr.get(i).messageType = message.messageType
                        break;
                    }
                }
                saama.core.pane.resetPane();
            }else if(message.messageType === "POSITION"){
                if(saama.core.pane.objArr.length()>0){
                    saama.core.pane.objArr.clear();
                }
                Object.keys(message.users).forEach(function(k){
                    saama.core.pane.objArr.add(message.users[k]);
                });

                let features = Array();
                for (let i = 0; i < saama.core.pane.objArr.length(); i++) {
                    var tempFeature = saama.core.pane.objArr.get(i);
                    var p = tempFeature.position.split(",");
                    var points = [p[0],p[1]];
                    points = ol.proj.transform(points, 'EPSG:4326', 'EPSG:3857');
                    var feature = new ol.Feature({
                        geometry: new ol.geom.Point(points),
                    });
                    feature.setId(tempFeature.sender);
                    features.push(feature);
                }
                saama.Map.refreshFeatures(features);
            }else if(message.messageType === "LEAVE"){
                for (let i = 0; i < saama.core.pane.objArr.length(); i++) {
                    if(saama.core.pane.objArr.get(i).sender === message.sender){
                        saama.core.pane.objArr.remove(i);
                        break;
                    }
                }
                saama.core.pane.resetPane();
                saama.Map.removeFeatureById(message.sender);
            }
            // let result = JSON.parse(message.result);
            // let features = Array();
            //모바일에서 받은 좌표 지도에 refresh
            // if(message.type==="REFRESH_MY_LOCATION"){
            //     console.log(result.coord);
            //     let coord = JSON.parse(result.coord);
            //     //message.content가 한개
            //     var points = [coord.longitude,coord.latitude];
            //     points = ol.proj.transform(points, 'EPSG:4326', 'EPSG:3857');
            //     var feature = new ol.Feature({
            //         geometry: new ol.geom.Point(points),
            //     });
            //     feature.setId(result.sender);
            //     features.push(feature);
            //     saama.Map.refreshFeatures(features).done(function(features){
            //         saama.Map.moveToAll();
            //     });
            // }else if(message.type==="RESPONSE_ALL_LOCATIONS"){
            //     //message.content가 배열
            //     for (let i = 0; i < result.length; i++) {
            //         var tempFeature = result[i];
            //         console.log(tempFeature.userId);
            //         var tempFeatureLocation = JSON.parse(tempFeature.location);
            //         var points = [tempFeatureLocation.longitude,tempFeatureLocation.latitude];
            //         points = ol.proj.transform(points, 'EPSG:4326', 'EPSG:3857');
            //         var feature = new ol.Feature({
            //             geometry: new ol.geom.Point(points),
            //         });
            //         feature.setId(tempFeature.userId);
            //         features.push(feature);
            //     }
            //     saama.Map.refreshFeatures(features);
            // }
        },
        closeSocket: function(){
            var _self = this;
            _self.socket.close();
        }

    }
    saama = $.extend(saama || {}, {
        chat : chat
    });

})();

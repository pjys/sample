(function() {
    "use strict";

    window.feelUtil = {
        version: "1.0.0"
    };

    var util = {
        isEmpty : function(value) {
            return value === undefined || value == null || value == "";
        },
        isNotEmpty : function(value) {
            return !this.isEmpty(value);
        },
        // 디바이스 체크
        getDeviceCheck : function(){
            // 디바이스 종류 설정
            var pcDevice = "win16|win32|win64|mac|macintel";

            // 접속한 디바이스 환경
            if ( navigator.platform ) {
                if ( pcDevice.indexOf(navigator.platform.toLowerCase()) < 0 ) { //MOBILE
                    return false;
                } else { // PC
                    var widthSize = $(window).width();
                    if(widthSize > 768){
                        return true;	// PC
                    }else{
                        return false; //MOBILE
                    }
                }
            }
        },
        phoneFormatting : function(num){
            if(num.length==11){
                return num.substr(0,3)+"-"+num.substr(3,4)+"-"+num.substr(7,4)
            }else{
                throw "this is not phone number format";
            }
        },
        //이메일 정규식 체크
        email_check : function(email) {
            var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
            return reg.test(email);
        },
        characterCheck : function(obj) {
            var regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣\{\}\[\]\/?,;:|\)*~`!^\+┼<>\#$%&\'\"\\\(\=]/gi;
            if( regExp.test(obj.value) ){
                obj.value = obj.value.substring( 0 , obj.value.length - 1 ); // 입력한 특수문자 한자리 지움
            }
        },
        imageExists : function(image_url){

            var http = new XMLHttpRequest();

            http.open('HEAD', image_url, false);
            http.send();

            return http.status != 404;

        },
        getBase64FromImageUrl : function(url) {
            var img = new Image();

            img.setAttribute('crossOrigin', 'anonymous');

            img.onload = function () {
                var canvas = document.createElement("canvas");
                canvas.width =this.width;
                canvas.height =this.height;

                var ctx = canvas.getContext("2d");
                ctx.drawImage(this, 0, 0);

                var dataURL = canvas.toDataURL("image/png");

                alert(dataURL.replace(/^data:image\/(png|jpg);base64,/, ""));
            };

            img.src = url;
        },
        moveWithLoader: function(url){
            globalLoaderDark.start();
            location.href=url;
            // startSpinDimmedLoader();
            // /*아이폰이슈로 추가함*/
            // setTimeout(function() {
            //     location.href=url;
            // }, 500);
        }
    }
    feelUtil = $.extend(feelUtil || {}, {
        Util: util
    })
})();
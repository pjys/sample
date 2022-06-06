package com.pjys.history.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "BORADHISTORY")
public class HistoryDTO {
    @Id
    private String historyId;
    private String boradId;
    private String historyCommend;
    private String historyDt;
    private String userId;
    private String userName;
}

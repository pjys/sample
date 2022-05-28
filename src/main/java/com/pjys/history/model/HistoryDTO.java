package com.pjys.history.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "boradhistory")
public class HistoryDTO {
    @Id
    private String history_id;
    private String history_dt;
    private String borad_id;
    private String user_id;
    private String user_name;
    private String history_commend;
}

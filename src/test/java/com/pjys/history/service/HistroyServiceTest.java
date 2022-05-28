package com.pjys.history.service;

import com.pjys.history.model.HistoryDTO;
import com.pjys.history.repository.HistroyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class HistroyServiceTest {

    @InjectMocks
    private HistroyService histroyService;

    @Mock
    private HistroyRepository histroyRepository;

    @Test
    @DisplayName("borad 모든 이력 조회 TEST")
    void allSelectHistoryTest() {
        when(histroyRepository.findAll()).thenReturn(new ArrayList<>(){
            {
                add(HistoryDTO.builder().user_name("이연희").build());
            }
        });
        List<HistoryDTO> historyDTOList = histroyService.allSelectHistory();
        assertNotNull(historyDTOList);
        assertEquals(historyDTOList.get(0).getUser_name(), "이연희");
    }

}
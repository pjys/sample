package com.pjys.history.service;

import com.pjys.history.model.HistoryDTO;
import com.pjys.history.repository.HistroyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HistroyService {

    private final HistroyRepository histroyRepository;

    public List<HistoryDTO> allSelectHistory(){
        return histroyRepository.findAll();
    }
}

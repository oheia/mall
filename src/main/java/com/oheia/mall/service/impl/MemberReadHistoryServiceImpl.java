package com.oheia.mall.service.impl;

import com.oheia.mall.nosql.mongodb.document.MemberReadHistory;
import com.oheia.mall.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.oheia.mall.service.MemberReadHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 会员浏览记录管理Service实现类
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Resource
    private MemberReadHistoryRepository readHistoryRepository;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        readHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = ids.stream().map(id -> {
            MemberReadHistory history = new MemberReadHistory();
            history.setId(id);
            return history;
        }).collect(Collectors.toList());
        readHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return readHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}

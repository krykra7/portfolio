package com.krystiankrawczyk.portfolio.provider;

import com.krystiankrawczyk.portfolio.api.response.GetSummaryResponse;
import com.krystiankrawczyk.portfolio.exception.AppException;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.provider.mapper.SummaryResponseMapper;
import com.krystiankrawczyk.portfolio.repository.SummaryRepository;

import org.springframework.stereotype.Component;

@Component
public class SummaryProvider {

    private final SummaryRepository summaryRepository;
    private final SummaryResponseMapper summaryResponseMapper;

    public SummaryProvider(SummaryRepository summaryRepository,
                           SummaryResponseMapper summaryResponseMapper) {
        this.summaryRepository = summaryRepository;
        this.summaryResponseMapper = summaryResponseMapper;
    }

    public GetSummaryResponse getLatestRevision() {
        return summaryRepository
                .findLatest()
                .map(summaryResponseMapper::map)
                .orElseThrow(() -> {
                    throw new AppException(ApiMessageCode.SUMMARY_DATA_NOT_FOUND);
                });
    }
}

package com.krystiankrawczyk.portfolio.provider;

import com.krystiankrawczyk.portfolio.api.response.GetSummaryResponse;
import com.krystiankrawczyk.portfolio.api.response.GetSummaryResponseBuilder;
import com.krystiankrawczyk.portfolio.db.SummaryDb;
import com.krystiankrawczyk.portfolio.exception.AppException;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.exception.message.MessageProvider;
import com.krystiankrawczyk.portfolio.provider.mapper.SummaryResponseMapper;
import com.krystiankrawczyk.portfolio.repository.SummaryRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import javax.mail.Message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SummaryProviderTest {

    @Mock
    private SummaryRepository summaryRepository;

    @Mock
    private SummaryResponseMapper summaryResponseMapper;

    @Mock
    private MessageProvider messageProvider = new MessageProvider();

    @InjectMocks
    private SummaryProvider underTest;

    @Test
    void shouldGetLatestRevision() {
        // Given
        SummaryDb summaryDb = new SummaryDb();
        GetSummaryResponse summaryResponse = new GetSummaryResponseBuilder().build();
        when(summaryRepository.findLatest()).thenReturn(Optional.of(summaryDb));
        when(summaryResponseMapper.map(summaryDb)).thenReturn(summaryResponse);
        // When
        GetSummaryResponse result = underTest.getLatestRevision();
        // Then
        assertThat(result).isSameAs(summaryResponse);
        verify(summaryRepository).findLatest();
        verify(summaryResponseMapper).map(summaryDb);
        verifyNoMoreInteractions(summaryRepository, summaryResponseMapper);
    }

    @Test
    void shouldThrowException_WhenSummaryDoesNotExist() {
        // Given
        // When
        Assertions.assertThatThrownBy(() -> {
                    underTest.getLatestRevision();
                }).isInstanceOf(AppException.class)
                .hasMessage(MessageProvider.getMessage(ApiMessageCode.SUMMARY_DATA_NOT_FOUND));
        // Then
    }
}

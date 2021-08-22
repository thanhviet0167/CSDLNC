package api.service;

import api.web.rest.vm.PaymentMethodStatisticsVM;
import api.web.rest.vm.TransportMethodStatisticsVM;

public interface AdminStatisticsService {
    TransportMethodStatisticsVM getTransportMethodStatistics(String from, String to);

    PaymentMethodStatisticsVM getPaymentMethodStatistics(String from, String to);
}

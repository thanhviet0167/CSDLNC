package api.service;

import api.web.rest.vm.PaymentMethodStatisticsVM;
import api.web.rest.vm.StoreStatisticsVM;
import api.web.rest.vm.SuccessOrderStatisticsVM;
import api.web.rest.vm.TransportMethodStatisticsVM;

public interface AdminStatisticsService {
    TransportMethodStatisticsVM getTransportMethodStatistics(String from, String to);

    PaymentMethodStatisticsVM getPaymentMethodStatistics(String from, String to);

    StoreStatisticsVM getStoreRateStatistics(String from, String to);

    StoreStatisticsVM getStoreComplainStatistics(String from, String to);

    SuccessOrderStatisticsVM getSuccessOrderStatistics(Integer year);
}

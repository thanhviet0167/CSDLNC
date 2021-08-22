package api.web.rest;

import api.security.JWTService;
import api.service.AdminStatisticsService;
import api.web.rest.vm.PaymentMethodStatisticsVM;
import api.web.rest.vm.StoreStatisticsVM;
import api.web.rest.vm.SuccessOrderStatisticsVM;
import api.web.rest.vm.TransportMethodStatisticsVM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/admin")
public class AdminStatisticsResource {

    private final AdminStatisticsService adminStatisticsService;
    private final JWTService jwtService;

    public AdminStatisticsResource(AdminStatisticsService adminStatisticsService, JWTService jwtService) {
        this.adminStatisticsService = adminStatisticsService;
        this.jwtService = jwtService;
    }

    @GetMapping("/statistics/transport-method")
    public ResponseEntity<TransportMethodStatisticsVM> getTransportMethodStatistics(
            HttpServletRequest request,
            @RequestParam String from,
            @RequestParam String to
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        TransportMethodStatisticsVM statisticsVM = adminStatisticsService.getTransportMethodStatistics(from, to);

        return ResponseEntity.ok(statisticsVM);
    }

    @GetMapping("/statistics/payment-method")
    public ResponseEntity<PaymentMethodStatisticsVM> getPaymentMethodStatistics(
            HttpServletRequest request,
            @RequestParam String from,
            @RequestParam String to
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        PaymentMethodStatisticsVM statisticsVM = adminStatisticsService.getPaymentMethodStatistics(from, to);

        return ResponseEntity.ok(statisticsVM);
    }

    @GetMapping("/statistics/store")
    public ResponseEntity<StoreStatisticsVM> getStoreStatistics(
            HttpServletRequest request,
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam Integer type
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (type == 1) {
            return ResponseEntity.ok(adminStatisticsService.getStoreRateStatistics(from, to));
        } else  {
            return ResponseEntity.ok(adminStatisticsService.getStoreComplainStatistics(from, to));
        }
    }

    @GetMapping("/statistics/success-order")
    public ResponseEntity<SuccessOrderStatisticsVM> getSuccessOrderStatistics(
            HttpServletRequest request,
            @RequestParam Integer year
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(adminStatisticsService.getSuccessOrderStatistics(year));
    }
}

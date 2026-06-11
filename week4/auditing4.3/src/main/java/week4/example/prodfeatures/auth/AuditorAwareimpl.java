package week4.example.prodfeatures.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareimpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("sourav thakur ");
    }
}

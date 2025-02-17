package eu.openaire.mas.delivery.provider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import eu.openaire.mas.delivery.MetricEntry;

/**
 * Embarrasingly simple metrics provider.
 * 
 * @author mhorst
 *
 */
@Service
public class DummyMetricsProvider implements MetricsProvider {

    private final AtomicLong counter = new AtomicLong();

    @Override
    public MetricEntry deliver(String resourceId, String metricId, String from, String to) {
        return new MetricEntry(resourceId, metricId, counter.incrementAndGet());
    }

    @Override
    public Set<String> list(String resourceId) {
        return new HashSet<String>(Arrays.asList(new String[] {"dummy"}));
    }

    @Override
    public Set<String> listResources() {
	return new HashSet<String>(Arrays.asList(new String[] {"dummy"}));
    }
}

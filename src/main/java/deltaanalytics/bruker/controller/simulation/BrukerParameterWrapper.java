package deltaanalytics.bruker.controller.simulation;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("simulation")
@Component
public class BrukerParameterWrapper {
    private BrukerParameters brukerParameters = BrukerParameters.getDefault();

    public BrukerParameters getBrukerParameters() {
        return brukerParameters;
    }

    public void setBrukerParameters(BrukerParameters brukerParameters) {
        this.brukerParameters = brukerParameters;
    }
}

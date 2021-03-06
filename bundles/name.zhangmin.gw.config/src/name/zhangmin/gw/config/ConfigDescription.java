package name.zhangmin.gw.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The {@link ConfigDescription} class contains a description for a concrete
 * configuration of e.g. a {@code Thing}, or other specific configurable 
 * services. This class <i>does not</i> contain the configuration
 * data itself and is usually used for data validation of the concrete
 * configuration or for supporting user interfaces.
 * <p>
 * The description is stored within the {@link ConfigDescriptionRegistry} under
 * the given URI. The URI has to follow the syntax
 * {@code 'scheme://<token>:<token>:...'}.
 * <p>
 * <b>Hint:</b> This class is immutable.
 * 
 * @author ZhangMin.name
 */
public class ConfigDescription {

    private String uri;
    private List<ConfigDescriptionParameter> parameters;


    /**
     * Creates a new instance of this class with the specified parameter.
     * 
     * @param uri the URI of this description within the {@link ConfigDescriptionRegistry}
     * @throws IllegalArgumentException if the URI is null or empty
     */
    public ConfigDescription(String uri) throws IllegalArgumentException {
        this(uri, null);
    }

    /**
     * Creates a new instance of this class with the specified parameters.
     * 
     * @param uri the URI of this description within the {@link ConfigDescriptionRegistry}
     *     (must neither be null nor empty)
     * 
     * @param parameters the description of a concrete configuration parameter
     *     (could be null or empty)
     *  
     * @throws IllegalArgumentException if the URI is null or empty
     */
    public ConfigDescription(String uri, List<ConfigDescriptionParameter> parameters)
            throws IllegalArgumentException {

        if ((uri == null) || (uri.isEmpty())) {
            throw new IllegalArgumentException("The URI must neither be null nor empty!");
        }

        this.uri = uri;

        if (parameters != null) {
            this.parameters = Collections.unmodifiableList(parameters);
        } else {
            this.parameters = Collections.unmodifiableList(new ArrayList<ConfigDescriptionParameter>(0));
        }
    }

    /**
     * Returns the URI of this description within the {@link ConfigDescriptionRegistry}.
     * The URI follows the syntax {@code 'scheme://<token>:<token>:...'}.
     *  
     * @return the URI of this description (neither null, nor empty)
     */
    public String getURI() {
        return this.uri;
    }

    /**
     * Returns the description of a concrete configuration parameter.
     * <p>
     * The returned list is immutable.
     * 
     * @return the description of a concrete configuration parameter (not null, could be empty)
     */
    public List<ConfigDescriptionParameter> getParameters() {
        return this.parameters;
    }

}

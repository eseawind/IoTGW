package name.zhangmin.gw.config;



/**
 * The {@link ConfigDescriptionParameter} class contains the description of a concrete
 * configuration parameter. Such parameter descriptions are collected within the
 * {@link ConfigDescription} and can be retrieved from the {@link ConfigDescriptionRegistry}.
 * 
 * @author ZhangMin.name
 */
public class ConfigDescriptionParameter {

    /**
     * The {@link Type} defines an enumeration of all supported data types
     * a configuration parameter can take.
     * 
     * @author ZhangMin.name
     */
    public enum Type {

        /**
         * The data type for a UTF8 text value.
         */
        TEXT,

        /**
         * The data type for a signed integer value in the range of
         * [{@link Integer#MIN_VALUE}, {@link Integer#MAX_VALUE}].
         */
        INTEGER,

        /**
         * The data type for a signed floating point value (IEEE 754) in the range of
         * [{@link Float#MIN_VALUE}, {@link Float#MAX_VALUE}].
         */
        DECIMAL,

        /**
         * The data type for a boolean ({@code true} or {@code false}).
         */
        BOOLEAN;

    }

    /**
     * The {@link Context} defines an enumeration of some specific context
     * a configuration parameter can take. A context is usually used for
     * specific input validation or user interfaces.
     * 
     * @author ZhangMin.name
     */
    public enum Context {

        /**
         * The context for a network address (e.g. IPv4, IPv6, etc.).
         */
        NETWORK_ADDRESS,

        /**
         * The context for a password (hidden field).
         */
        PASSWORD,

        /**
         * The context for an email address.
         */
        EMAIL;

    }

    private String name;
    private Type type;

    private Context context;
    private String label;
    private boolean required;
    private String description;
    private Object defaultValue;


    /**
     * Creates a new instance of this class with the specified parameters.
     * 
     * @param name the name of the configuration parameter (must neither be null nor empty)
     * @param type the data type of the configuration parameter (must not be null)
     * 
     * @throws IllegalArgumentException if the name is null or empty, or the type is null
     */
    public ConfigDescriptionParameter(String name, Type type) throws IllegalArgumentException {
        this(name, type, null, false, null, null, null);
    }

    /**
     * Creates a new instance of this class with the specified parameters.
     * 
     * @param name the name of the configuration parameter (must neither be null nor empty)
     * @param type the data type of the configuration parameter (must not be null)
     * @param context the context of the configuration parameter (could be null)
     * @param required the flag indicating if the configuration parameter has to be set or not
     * @param defaultValue the default value of the configuration parameter (could be null)
     * @param label a human readable label for the configuration parameter (could be null or empty)
     * @param description a human readable description for the configuration parameter
     *     (could be null or empty) 
     * 
     * @throws IllegalArgumentException if the name is null or empty, or the type is null
     */
    public ConfigDescriptionParameter(String name, Type type,
            Context context, boolean required, Object defaultValue,
            String label, String description) throws IllegalArgumentException {

        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("The name must neither be null nor empty!");
        }

        if (type == null) {
            throw new IllegalArgumentException("The type must not be null!");
        }

        this.name = name;
        this.type = type;

        this.context = context;
        this.required = required;
        this.defaultValue = defaultValue;
        this.label = label;
        this.description = description;
    }

    /**
     * Returns the name of the configuration parameter.
     * 
     * @return the name of the configuration parameter (neither null, nor empty)
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the data type of the configuration parameter.
     * 
     * @return the data type of the configuration parameter (not null)
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Returns the context of the configuration parameter.
     * 
     * @return the context of the configuration parameter (could be null)
     */
    public Context getContext() {
        return this.context;
    }

    /**
     * Returns {@code true} if the configuration parameter has to be set, otherwise {@code false}.
     * 
     * @return true if the configuration parameter has to be set, otherwise false
     */
    public boolean isRequired() {
        return this.required;
    }

    /**
     * Returns the default value of the configuration parameter.
     * 
     * @return the default value of the configuration parameter (could be null)
     */
    public Object getDefault() {
        return this.defaultValue;
    }

    /**
     * Returns a human readable label for the configuration parameter.
     * 
     * @return a human readable label for the configuration parameter (could be null or empty)
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Returns a human readable description for the configuration parameter.
     * 
     * @return a human readable description for the configuration parameter (could be null or empty)
     */
    public String getDescription() {
        return this.description;
    }

}

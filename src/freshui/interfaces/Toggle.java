package freshui.interfaces;

public interface Toggle {

    boolean getStatus();

    /**
     * Sets the status of the toggle to be true/false.
     */
    void setStatus(boolean b);


    boolean isEnabled();

    /**
     * Sets the toggle to an enabled/disabled status.
     * When the toggle is disabled, no input from the user should be accepted.
     */
    void setEnabled(boolean b);

}

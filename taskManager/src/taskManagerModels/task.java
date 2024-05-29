package taskManagerModels;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class task implements Serializable {
    /*
     * Things associated with a tasK:
     * 1. Task Name
     * 2. Task Due Date
     * 3. Task List (if Applicable)
     * 4. Priority
     * 5. Status
     * 6. Expected Time
     * 7. Expected Time Unit
     * 8. Reminder Date
     * 9. Attachment
     * 10. Task Description
     * --- Invisible Fields ----
     * 11. UserID
     * 12. TaskID
     * 13. CreatedAt
     * 14. CompletedAt
     */

    private String taskName, taskList, expectedTimeUnit, attachmentURL, taskDescription, priority;
    private Date dueDate, reminderDate;
    private int expectedTime, userID, taskID;
    private Timestamp createdAt, completedAt;

    public task() {

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskList() {
        return taskList;
    }

    public void setTaskList(String taskList) {
        this.taskList = taskList;
    }

    public String getExpectedTimeUnit() {
        return expectedTimeUnit;
    }

    public void setExpectedTimeUnit(String expectedTimeUnit) {
        this.expectedTimeUnit = expectedTimeUnit;
    }

    public String getAttachmentURL() {
        return attachmentURL;
    }

    public void setAttachmentURL(String attachmentURL) {
        this.attachmentURL = attachmentURL;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public int getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(int expectedTime) {
        this.expectedTime = expectedTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Timestamp completedAt) {
        this.completedAt = completedAt;
    }

}

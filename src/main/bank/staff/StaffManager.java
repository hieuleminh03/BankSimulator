package staff;

import java.util.ArrayList;
import java.util.List;

public class StaffManager {
    private static StaffManager instance;
    private final List<Staff> staffs;

    private StaffManager() {
        staffs = new ArrayList<>();
    }

    public static StaffManager getInstance() {
        if (instance == null) {
            instance = new StaffManager();
        }
        return instance;
    }

    public void addStaff(Staff staff) {
        staffs.add(staff);
    }

    public Staff getAvailableStaff() {
        for (Staff staff : staffs) {
            if (staff.getStaffStatus() == Staff.StaffStatus.AVAILABLE) {
                return staff;
            }
        }
        return null;
    }
}

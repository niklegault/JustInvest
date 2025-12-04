package ca.carleton.niklegault.justInvest;

import java.time.Clock;
import java.time.LocalTime;
import java.util.Calendar;


public class AccessControl {

    private final Clock clock;
    private final Calendar cal;

    public AccessControl() {
        this.cal = Calendar.getInstance();
        this.clock = Clock.systemDefaultZone();
    }

    public AccessControl(Clock clock, Calendar cal) {
        this.clock = clock;
        this.cal = cal;
    }

    public boolean hasAccess(User user, Actions action) {
        Roles userRole = user.getRole();
        if(userRole == Roles.TELLER && (LocalTime.now(clock).getHour() < 9 || LocalTime.now(clock).getHour() >= 17 ||
                cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return false;
        }
        switch(action) {
            case VIEW_ACCOUNT_BALANCE:
            case VIEW_INVESTMENT_PORTFOLIO:
                return true;
            case VIEW_FINANCIAL_ADVISOR_INFO:
                if(userRole == Roles.CLIENT || userRole == Roles.PREMIUM_CLIENT) return true;
                break;
            case VIEW_FINANCIAL_PLANNER_INFO:
                if(userRole == Roles.PREMIUM_CLIENT) return true;
                break;
            case MODIFY_INVESTMENT_PORTFOLIO:
                if(userRole == Roles.PREMIUM_CLIENT || userRole == Roles.FINANCIAL_ADVISOR || userRole == Roles.FINANCIAL_PLANNER)
                    return true;
                break;
            case VIEW_PRIVATE_CONSUMER_INSTRUMENTS:
                if(userRole == Roles.FINANCIAL_PLANNER || userRole == Roles.FINANCIAL_ADVISOR) return true;
                break;
            case VIEW_MONEY_MARKET_INSTRUMENTS:
                if(userRole == Roles.FINANCIAL_PLANNER) return true;
                break;
            default:
                return false;
        }
        return false;
    }
}

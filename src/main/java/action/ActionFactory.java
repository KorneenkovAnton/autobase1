package action;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private Map<String,Action> actionMap = new HashMap<>();

    ActionFactory(){
        actionMap.put("/register", new RegisterAction());
        actionMap.put("/login",new LoginAction());
        actionMap.put("/main", new MainPageAction());
        actionMap.put("/appoint", new AppointCarForFlight());
        actionMap.put("/markFlight",new MarkFLightAction());
        actionMap.put("/markCarState",new MarkStateAction());
        actionMap.put("/logout", new LogoutAction());
        actionMap.put("/newReq",new NewReqAction());
        actionMap.put("/addCar",new AddCarAction());
    }

    public synchronized Action getAction(HttpServletRequest request){
        String key = request.getServletPath();
        return actionMap.get(key);
    }
}

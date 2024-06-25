
package Controllers;

import Dao.GlobalDao;
import ViewsUI.LoginView;


public class AutenticacaoController {
    
    
    public AutenticacaoController() {
        
    }
    
    public void LoginAction(){
        new LoginView().setVisible(true);
    }
}

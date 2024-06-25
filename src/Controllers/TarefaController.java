
package Controllers;

import Dao.GlobalDao;
import ViewsUI.LoginView;
import ViewsUI.TarefaView;

public class TarefaController {
    public GlobalDao context;

    public TarefaController(GlobalDao _context) {
        context = _context;
    }

    public void IndexAction() {
        if (context.isAuthenticated())
            new TarefaView(context).setVisible(true);
        else
            new LoginView().setVisible(true);
    }

}

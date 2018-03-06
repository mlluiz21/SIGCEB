package controle.filtro;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import controle.LoginMB;

@SuppressWarnings("serial")
public class LoginCheckPhaseListener implements PhaseListener {

	// CICLO DE VIDA DO JSF
	// 1. Restore view
	// 2. Apply request values; process events
	// 3. Process validations; process events
	// 4. Update model values; process events
	// 5. Invoke application; process events
	// 6. Render response

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW; // executar na primeira fase (início do
										// processamento)
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext contexto = event.getFacesContext();
		LoginMB loginMB = contexto.getApplication().evaluateExpressionGet(
				contexto, "#{loginMB}", LoginMB.class);

		boolean usuarioAutenticado = false;
		if (loginMB != null)
			usuarioAutenticado = loginMB.isAutenticado();

		String pagina = contexto.getViewRoot().getViewId();
		boolean estaNaPaginaDeLogin = pagina.indexOf("login") > -1 ? true : false;

		if (!estaNaPaginaDeLogin && !usuarioAutenticado) {
			NavigationHandler nh = contexto.getApplication()
					.getNavigationHandler();
			nh.handleNavigation(contexto, null, "login.jsf");
		}

	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

}

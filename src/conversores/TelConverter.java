package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="tel-converter")
public class TelConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		if (valor != null)
			valor = valor.replaceAll("[-()]", "");

		return valor;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		return valor.toString();
	}

}

import static javax.swing.JOptionPane.*;

public class Client {

  public static void main(String[] args) {
  	DumbEmployee e = new DumbEmployee("Halvor", "Bø", 1998, 1, 2013, 50000.0, 0.35);
  	boolean run = true;
  	while(run) {
  		switch(Integer.parseInt(showInputDialog(null, "1. Fornavn\n2. Etternavn\n3. Id\n4. Lønn\n5. Skatteprosent\n6. Ferdig"))) {
  			case 1:
  				e.setFirstName(showInputDialog(null, "Fornavn"));
  				break;
  			case 2:
  				e.setLastName(showInputDialog(null, "Etternavn"));
  				break;
  			case 3:
  				e.setEmployeeIdNumber(Integer.parseInt(showInputDialog(null, "Id")));
  				break;
  			case 4:
  				e.setWage(Double.parseDouble(showInputDialog(null, "Lønn")));
  				break;
  			case 5:
  				e.setTaxPercentage(Double.parseDouble(showInputDialog(null, "Skatteprosent")));
  				break;
  			case 6:
  				run = false;
  		}
  		showMessageDialog(null, e);

  	}

  }

}
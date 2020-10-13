/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Chavez Vigil
 */
public class Calculos {

    DefaultComboBoxModel model = null;

    public void Municipios(int depto, JComboBox combo) {
        try {

            switch (depto) {
                case 0:
                    model = new DefaultComboBoxModel();
                    model.addElement("Ahuachapán");
                    model.addElement("Jujutla");
                    model.addElement("Atiquizaya");
                    model.addElement("Ataco");
                    model.addElement("El Refugio");
                    model.addElement("Guaymango");
                    model.addElement("Apaneca");
                    model.addElement("San Francisco");
                    model.addElement("San Lorenzo");
                    model.addElement("San Pedro");
                    model.addElement("Tacuba");
                    model.addElement("Turín");
                    combo.setModel(model);
                    break;
                case 3:
                    model = new DefaultComboBoxModel();
                    model.addElement("Cisquera");
                    model.addElement("Dolores");
                    model.addElement("Guacotecti");
                    model.addElement("Ilobasco");
                    model.addElement("Jutiapa");
                    model.addElement("San Isidro");
                    model.addElement("Sensuntepeque");
                    model.addElement("Tejutepeque");
                    model.addElement("Victoria");
                    combo.setModel(model);
                    break;
                case 1:
                    model = new DefaultComboBoxModel();
                    model.addElement("Cojutepeque");
                    model.addElement("Candelaria");
                    model.addElement("El Carmen");
                    model.addElement("El Rosario");
                    model.addElement("San Juan");
                    model.addElement("Concepción");
                    model.addElement("San Bartolomé");
                    model.addElement("San Cristóbal");
                    model.addElement("Guayabal");
                    model.addElement("Perulapán");
                    model.addElement("San Rafael");
                    model.addElement("San Ramon");
                    model.addElement("Analquito");
                    model.addElement("Michapa");
                    model.addElement("Suchitoto");
                    model.addElement("Tenancingo");
                    combo.setModel(model);
                    break;

                case 2:
                    model = new DefaultComboBoxModel();
                    model.addElement("Agua Caliente");
                    model.addElement("Arcatao");
                    model.addElement("Azacualpa");
                    model.addElement("El Carrizal");
                    model.addElement("Chalatenango");
                    model.addElement("Citalá");
                    model.addElement("Comalapa");
                    model.addElement("Quezaltepeque");
                    model.addElement("Dulce");
                    model.addElement("La Laguna");
                    model.addElement("Nombre Jesus");
                    model.addElement("Concepción");
                    model.addElement("Trinidad");
                    model.addElement("Ojos de Agua");
                    model.addElement("La Palma");
                    model.addElement("El Paraíso");
                    model.addElement("Potonico");
                    model.addElement("La Reina");
                    model.addElement("De la Cruz");
                    model.addElement("Los Ranchos");
                    model.addElement("San Fernando");
                    model.addElement("Lempa");
                    model.addElement("Morazán");
                    model.addElement("San Ignacio");
                    model.addElement("San Isidro");
                    model.addElement("Cancasque");
                    model.addElement("Las Flores");
                    model.addElement("San Luis");
                    model.addElement("Mercedes");
                    model.addElement("San Rafael");
                    model.addElement("Santa Rita");
                    model.addElement("Tejutla");
                    model.addElement("Las Vueltas");
                    combo.setModel(model);
                    break;

                case 5:
                    model = new DefaultComboBoxModel();
                    model.addElement("La Unión");
                    model.addElement("San Alejo");
                    model.addElement("Yucuaiquín");
                    model.addElement("Conchagua");
                    model.addElement("Intipuca");
                    model.addElement("San José");
                    model.addElement("El Carmen");
                    model.addElement("Yayantique");
                    model.addElement("Bolívar");
                    model.addElement("Meanguera");
                    model.addElement("Santa Rosa");
                    model.addElement("Pasaquina");
                    model.addElement("Anamoros");
                    model.addElement("Esparta");
                    model.addElement("El Sauce");
                    model.addElement("Concepción");
                    model.addElement("Poloros");
                    model.addElement("Lislique");
                    combo.setModel(model);
                    break;

                case 4:
                    model = new DefaultComboBoxModel();
                    model.addElement("Antiguo Cus");
                    model.addElement("Chiltiupan");
                    model.addElement("Cuidad Arce");
                    model.addElement("Colon");
                    model.addElement("Comasagua");
                    model.addElement("Huizucar");
                    model.addElement("Jayaque");
                    model.addElement("Jicalapa");
                    model.addElement("La Libertad");
                    model.addElement("Santa Tecla");
                    model.addElement("Nuevo Cus");
                    model.addElement("Opico");
                    model.addElement("Quezaltepeque");
                    model.addElement("Sacacoyo");
                    model.addElement("Villanueva");
                    model.addElement("San Matías");
                    model.addElement("Tacachico");
                    model.addElement("Talnique");
                    model.addElement("Tamanique");
                    model.addElement("Teotepeque");
                    model.addElement("Tepecoyo");
                    model.addElement("Zaragoza");
                    combo.setModel(model);
                    break;

                case 6:
                    model = new DefaultComboBoxModel();
                    model.addElement("Zacatecoluca");
                    model.addElement("Cuyultitan");
                    model.addElement("El Rosario");
                    model.addElement("Jerusalen");
                    model.addElement("La Ceiba");
                    model.addElement("Olocuilta");
                    model.addElement("Paraiso");
                    model.addElement("San Antonio");
                    model.addElement("San Emigdio");
                    model.addElement("Chinameca");
                    model.addElement("Pedro Masah");
                    model.addElement("Juan Nonualc");
                    model.addElement("Juan Talpa");
                    model.addElement("Juan Tepezon");
                    model.addElement("Herradura");
                    model.addElement("Luis Talpa");
                    model.addElement("Miguel Tepez");
                    model.addElement("Pedro Nonualc");
                    model.addElement("Obrajuelo");
                    model.addElement("Ostuma");
                    model.addElement("Santiago Non");
                    model.addElement("Tapalhuaca");
                    combo.setModel(model);
                    break;

                case 7:
                    model = new DefaultComboBoxModel();
                    model.addElement("Arambala");
                    model.addElement("Cacaopera");
                    model.addElement("Chilanga");
                    model.addElement("Corinto");
                    model.addElement("Delicias");
                    model.addElement("Divisadero");
                    model.addElement("El Rosario");
                    model.addElement("Gualococti");
                    model.addElement("Guatajiagua");
                    model.addElement("Joateca");
                    model.addElement("Jocoatique");
                    model.addElement("Jocoro");
                    model.addElement("Lolotiquillo");
                    model.addElement("Meanguera");
                    model.addElement("Osicala");
                    model.addElement("Perquín");
                    model.addElement("San Carlos");
                    model.addElement("San Fernando");
                    model.addElement("Gotera");
                    model.addElement("San Isidro");
                    model.addElement("San Simón");
                    model.addElement("Sensembra");
                    model.addElement("Sociedad");
                    model.addElement("Torola");
                    model.addElement("Yamabal");
                    model.addElement("Yoloaiquín");
                    combo.setModel(model);
                    break;

                case 9:
                    model = new DefaultComboBoxModel();
                    model.addElement("Candelaria");
                    model.addElement("Chalchuapa");
                    model.addElement("Coatepeque");
                    model.addElement("El Congo");
                    model.addElement("El Porvenir");
                    model.addElement("Masahuat");
                    model.addElement("Metapán");
                    model.addElement("El Pajonal");
                    model.addElement("Salitrio");
                    model.addElement("Santa Ana");
                    model.addElement("Guachipilín");
                    model.addElement("Santiago");
                    model.addElement("Texistepeque");
                    combo.setModel(model);
                    break;

                case 11:
                    model = new DefaultComboBoxModel();
                    model.addElement("Aguilares");
                    model.addElement("Apopa");
                    model.addElement("Ayutuxtepeque");
                    model.addElement("Cuscatancingo");
                    model.addElement("Delgado");
                    model.addElement("El Paisnal");
                    model.addElement("Guazapa");
                    model.addElement("Ilopango");
                    model.addElement("Mejicanos");
                    model.addElement("Nejapa");
                    model.addElement("Panchimalco");
                    model.addElement("Rosario");
                    model.addElement("San Marcos");
                    model.addElement("San Martín");
                    model.addElement("San Salvador");
                    model.addElement("Texacuangos");
                    model.addElement("Santo Tomás");
                    model.addElement("Soyapango");
                    model.addElement("Tonacatepeque");
                    combo.setModel(model);
                    break;

                case 12:
                    model = new DefaultComboBoxModel();
                    model.addElement("Carolina");
                    model.addElement("Chapeltique");
                    model.addElement("Chinameca");
                    model.addElement("Chirilagua");
                    model.addElement("Barrios");
                    model.addElement("Comacarán");
                    model.addElement("Tránsito");
                    model.addElement("Lolotique");
                    model.addElement("Moncagua");
                    model.addElement("Guadalupe");
                    model.addElement("Edén");
                    model.addElement("Quelepa");
                    model.addElement("San Antonio");
                    model.addElement("San Gerardo");
                    model.addElement("San Jorge");
                    model.addElement("San Luis");
                    model.addElement("San Miguel");
                    model.addElement("San Rafael");
                    model.addElement("Sesori");
                    model.addElement("Uluazapa");
                    combo.setModel(model);
                    break;

                case 10:

                    model = new DefaultComboBoxModel();
                    model.addElement("Apastepeque");
                    model.addElement("Guadalupe");
                    model.addElement("Cayetano");
                    model.addElement("San Esteban");
                    model.addElement("San Idefonso");
                    model.addElement("San Lorenzo");
                    model.addElement("San Sebastiá");
                    model.addElement("San Vicente");
                    model.addElement("Santa Clara");
                    model.addElement("Domingo");
                    model.addElement("Tecoluca");
                    model.addElement("Tepetitan");
                    model.addElement("Verapaz");
                    combo.setModel(model);
                    break;

                case 8:

                    model = new DefaultComboBoxModel();
                    model.addElement("Acajutla");
                    model.addElement("Armenia");
                    model.addElement("Caluco");
                    model.addElement("Cuisnahuat");
                    model.addElement("Izalco");
                    model.addElement("Juayúa");
                    model.addElement("Nahuizalco");
                    model.addElement("Nahulingo");
                    model.addElement("Salcoatitán");
                    model.addElement("San Antonio");
                    model.addElement("San Julián");
                    model.addElement("Catarina Mas");
                    model.addElement("Santa Isabel");
                    model.addElement("Domingo");
                    model.addElement("Sonsonate");
                    model.addElement("Sonzacate");
                    combo.setModel(model);
                    break;

                case 13:
                    model = new DefaultComboBoxModel();
                    model.addElement("Alegría");
                    model.addElement("Berlín");
                    model.addElement("California");
                    model.addElement("Batres");
                    model.addElement("El Triunfo");
                    model.addElement("Ereguayquín");
                    model.addElement("Estanzuelas");
                    model.addElement("Jiquilisco");
                    model.addElement("Jucuapa");
                    model.addElement("Jucuarán");
                    model.addElement("Mercedes");
                    model.addElement("Granada");
                    model.addElement("Ozatlán");
                    model.addElement("Puerto Tri");
                    model.addElement("San Agustín");
                    model.addElement("Buenaventura");
                    model.addElement("San Dionisio");
                    model.addElement("San Francisco");
                    model.addElement("Santa Elena");
                    model.addElement("Santa María");
                    model.addElement("Santiago");
                    model.addElement("Tecapan");
                    model.addElement("Usulután");
                    combo.setModel(model);
                    break;
                case 14:
                    model = new DefaultComboBoxModel();
                    model.addElement("Guatemala");
                    model.addElement("Honduras");
                    model.addElement("Belice");
                    model.addElement("Nicaragua");
                    model.addElement("Costa Rica");
                    model.addElement("Panamá");
                    combo.setModel(model);
                    break;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String calcularDias(java.sql.Date fecha) {
        String dias = "";
        try {

            final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
            java.util.Date hoy = new Date(); //Fecha de hoy 

            int año = fecha.getYear() + 1900;
            int mes = fecha.getMonth() + 1;
            int dia = fecha.getDate();
            Calendar calendar = new GregorianCalendar(año, mes - 1, dia);
            java.sql.Date fec;
            fec = new java.sql.Date(calendar.getTimeInMillis());

            long diferencia = (hoy.getTime() - fec.getTime()) / MILLSECS_PER_DAY;
            dias = "Dias: " + String.valueOf(diferencia);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dias;
    }
}

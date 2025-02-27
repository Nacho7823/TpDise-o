package grupo3a.tp_diseno.Vista;

import grupo3a.tp_diseno.DTOs.AulaDTO;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.EsporadicaDias;
import grupo3a.tp_diseno.DTOs.BedelDTO;
import grupo3a.tp_diseno.DTOs.CuatrimestreDTO;
import grupo3a.tp_diseno.DTOs.DetalleReservaDTO;
import grupo3a.tp_diseno.DTOs.DisponibilidadDTO;
import grupo3a.tp_diseno.DTOs.ReservaDTO;
import grupo3a.tp_diseno.DTOs.UsuarioDTO;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoReservaPeriodica;
import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import grupo3a.tp_diseno.Exceptions.Exceptions;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Exceptions.Exceptions.ValueException;
import grupo3a.tp_diseno.Gestores.GestorBedel;
import grupo3a.tp_diseno.Gestores.GestorLogin;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Vista.Administrador.BuscarBedel;
import grupo3a.tp_diseno.Vista.Administrador.MenuAdmin;
import grupo3a.tp_diseno.Vista.Administrador.RegistrarBedel;
import grupo3a.tp_diseno.Vista.Administrador.ResultadosBusquedaBedel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import grupo3a.tp_diseno.Vista.Bedel.MenuBedel;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.CartelDetalles;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.RegistrarReservaDatos;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.ReservasSolapadas;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.ResultadosAulas;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.SeleccionTipoReserva;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.TipoPeriodicaDias;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.TipoPeriodicaHorarios;
import grupo3a.tp_diseno.Vista.Login.InicioSesion;
import grupo3a.tp_diseno.Vista.Utilidades.FuncionInterface.Fun;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JPanel;

public class Interfaz {

    // singleton
    private static Interfaz interfazInstance;

    public static Interfaz getInstance() {
        if (interfazInstance == null) {
            interfazInstance = new Interfaz();
        }
        return interfazInstance;
    }

    // clase
    // pantalla auxiliar que se usa para poder presentar alertas
    private BaseFrame baseFrame;

    private CardLayout cardLayout;
    private JPanel mainPanel;

    // paneles generales de alerta y confirmacion
    private Alerta alerta;
    private AlertaConfirmacion alertaConfirmacion;
    private CardLayout alertaCardLayout;
    private JPanel alertaPanel;

    private InicioSesion login;
    private MenuAdmin menuAdmin;
    private MenuBedel menuBedel;
    private BuscarBedel buscarBedel;
    private ResultadosBusquedaBedel resultadosBusquedaBedel;
    private RegistrarBedel registrarBedel;

    // Reserva
    private SeleccionTipoReserva regRsvaSeleccionTipoReserva = new SeleccionTipoReserva();
    private TipoPeriodicaDias regRsvaTipoPeriodicaDias = new TipoPeriodicaDias();
    private TipoPeriodicaHorarios regRsvaPeriodicaHorarios = new TipoPeriodicaHorarios();
    private RegistrarReservaDatos regRsvaDatos = new RegistrarReservaDatos();
    private ResultadosAulas regRsvaAula = new ResultadosAulas();
    private EsporadicaDias regAulaEsporadicaDias = new EsporadicaDias();
    private ReservasSolapadas reservasSolapadas= new ReservasSolapadas();
    

    // gestores
    private GestorBedel gestorBedel = GestorBedel.getInstance();
    private GestorLogin gestorLogin = GestorLogin.getInstance();
    private GestorReserva gestorReserva = GestorReserva.getInstance();

    // datos reserva
    private List<CuatrimestreDTO> cuatrimestres;
    private CuatrimestreDTO cuat1, cuat2;
    private ArrayList<DiaSemana> dias;
    private ArrayList<DetalleReservaDTO> listaDetalleReservaDTO;
    private DisponibilidadDTO disponibilidadDeAulas;
    private ReservaDTO reserva;
    private int idBedel;

    public Interfaz() {
        baseFrame = new BaseFrame();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        baseFrame.setResizable(true);
        baseFrame.getPanel1().setLayout(new BorderLayout());
        baseFrame.getPanel1().add(mainPanel, BorderLayout.CENTER);

        // alertas
        alertaCardLayout = new CardLayout();
        alertaPanel = new JPanel(alertaCardLayout);
        alertaPanel.setOpaque(false);
        baseFrame.getPanel2().setLayout(new BorderLayout());
        baseFrame.getPanel2().add(alertaPanel);
        alerta = new Alerta();
        alertaConfirmacion = new AlertaConfirmacion();
        alertaPanel.add(alerta, "alerta");
        alertaPanel.add(alertaConfirmacion, "alertaConfirmacion");


        baseFrame.setLocationRelativeTo(null);
        baseFrame.setVisible(true);

        login = new InicioSesion();
        menuAdmin = new MenuAdmin();
        menuBedel = new MenuBedel();
        buscarBedel = new BuscarBedel();
        resultadosBusquedaBedel = new ResultadosBusquedaBedel();
        registrarBedel = new RegistrarBedel();

        // Reserva
       /* regRsvaSeleccionTipoReserva = new SeleccionTipoReserva();
        regRsvaTipoPeriodicaDias = new TipoPeriodicaDias();
        regRsvaPeriodicaHorarios = new TipoPeriodicaHorarios();
        regRsvaDatos = new RegistrarReservaDatos();
        regRsvaAula = new ResultadosAulas();
        regAulaEsporadicaDias = new EsporadicaDias();*/


        mainPanel.add(login, "login");
        mainPanel.add(menuAdmin, "menuAdmin");
        mainPanel.add(menuBedel, "menuBedel");
        mainPanel.add(buscarBedel, "buscarBedel");
        mainPanel.add(resultadosBusquedaBedel, "resultadosBusquedaBedel");
        mainPanel.add(registrarBedel, "registrarBedel");
        // reserva
        mainPanel.add(regRsvaSeleccionTipoReserva, "regRsvaSeleccionTipoReserva");
        mainPanel.add(regRsvaTipoPeriodicaDias, "regRsvaTipoPeriodicaDias");
        mainPanel.add(regRsvaPeriodicaHorarios, "regRsvaPeriodicaHorarios");
        mainPanel.add(regRsvaDatos, "regRsvaDatos");
        mainPanel.add(regRsvaAula, "regRsvaAula");
        mainPanel.add(regAulaEsporadicaDias, "regAulaEsporadicaDias");
        mainPanel.add(reservasSolapadas,"reservasSolapadas");

        configureListeners();

        showLogin();

    }

    private void configureListeners() {

        // login
        login.setListener((String idLogin, String contrasena) -> {
            try {
                UsuarioDTO usuarioDTO = new UsuarioDTO(idLogin, contrasena, null, null);
                Boolean esAdmin = gestorLogin.validarLogin(usuarioDTO);

                if (esAdmin) {
                    showMenuAdmin();
                } else {
                    showMenuBedel();
                    idBedel = gestorLogin.getIdUsuarioLogueado();
                }
            } catch (DAOException e) {
                System.out.println(e.getMessage());
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            } catch (ValueException e) {
                System.out.println(e.getMessage());
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            } catch (Exceptions.BedelDeshabilitadoException e) {
                System.out.println(e.getMessage());
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            }
        });

        // menuAdmin
        menuAdmin.setListener(new MenuAdmin.Listener() {
            @Override 
            public void back(){
                gestorLogin.cerrarSesion();
                showLogin();
            }
            @Override
            public void registrarBedel() {
                showRegistrarBedel();
            }

            @Override
            public void buscarBedel() {
                showBuscarBedel();
            }
        });

        // buscarBedel
        buscarBedel.setListener(new BuscarBedel.Listener() {
            @Override
            public void back() {
                alertaConfirmacion.setText("¿Esta seguro que desea regresar?");
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
                baseFrame.setPanel2Up();
                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                        baseFrame.setPanel1Up();
                        showMenuAdmin();
                    }

                });
            }

            @Override
            public void next() {
                try {
                    List<BedelDTO> bedelesBuscados;
                    if (buscarBedel.getSeleccionado().equals("Apellido")) {
                        bedelesBuscados = gestorBedel.buscar(buscarBedel.getApellido());
                    } else {
                        bedelesBuscados = gestorBedel.buscar(buscarBedel.getTurno());
                    }

                    showResultadosBusquedaBedel(bedelesBuscados);

                } catch (NullPointerException | Exceptions.ValueException e) {
                    alerta.setText(e.getMessage());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                } catch (Exceptions.DAOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // resultadosBusquedaBedel
        resultadosBusquedaBedel.setListener(new ResultadosBusquedaBedel.Listener() {
            @Override
            public void back() {
                showBuscarBedel();
            }

            @Override
            public void deshabilitar(BedelDTO elegido, Fun fun) {
                alertaConfirmacion.setText("¿Esta seguro que desea deshabilitar el usuario " + elegido.getIdLogin() + "?");

                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                        try {
                            // TODO: cambiar nombre funcion
                            gestorBedel.eliminar(elegido.getIdUsuario());

                            alerta.setText("bedel deshabilitado con exito");
                            alerta.setListener(() -> baseFrame.setPanel1Up());

                            alertaCardLayout.show(alertaPanel, "alerta");
                            baseFrame.setPanel2Up();

                            fun.call(Boolean.TRUE);
                        } catch (Exceptions.DAOException ex) {
                            fun.call(Boolean.FALSE, ex);
                        }
                    }
                });
                baseFrame.setPanel2Up();
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
            }

            @Override
            public void habilitar(BedelDTO elegido, Fun fun) {
                alertaConfirmacion.setText("¿Esta seguro que desea habilitar el usuario " + elegido.getIdLogin() + "?");

                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                        try {
                            // TODO: cambiar nombre funcion
                            gestorBedel.habilitar(elegido.getIdUsuario());

                            alerta.setText("bedel habilitado con exito");
                            alerta.setListener(() -> baseFrame.setPanel1Up());

                            alertaCardLayout.show(alertaPanel, "alerta");
                            baseFrame.setPanel2Up();

                            fun.call(Boolean.TRUE);
                        } catch (Exceptions.DAOException ex) {
                            fun.call(Boolean.FALSE, ex);
                        }
                    }
                });
                baseFrame.setPanel2Up();
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
            }

            @Override
            public boolean modificar(BedelDTO bedel) {
                try {
                    gestorBedel.modificar(bedel);

                    alerta.setText("Bedel modificado con éxito");
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    try {
                        List<BedelDTO> bedelesBuscados;
                        if (buscarBedel.getSeleccionado().equals("Apellido")) {
                            bedelesBuscados = gestorBedel.buscar(buscarBedel.getApellido());
                        } else {
                            bedelesBuscados = gestorBedel.buscar(buscarBedel.getTurno());
                        }

                        showResultadosBusquedaBedel(bedelesBuscados);

                    } catch (NullPointerException | Exceptions.ValueException e) {
                        alerta.setText(e.getMessage());
                        alertaCardLayout.show(alertaPanel, "alerta");
                        baseFrame.setPanel2Up();
                        alerta.setListener(() -> baseFrame.setPanel1Up());
                    } catch (Exceptions.DAOException ex) {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return true;

                } catch (ValueException ex) {
                    alerta.setText("no se pudo modificar el bedel");
                    System.out.println(ex.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return false;
                }
            }

            @Override
            public void modificarError(Exception e) {
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            }

            @Override
            public void eliminarError(Exception e) {
                System.out.println("eliminar error interfaz");
                alerta.setText(e.getMessage());
                alerta.setListener(() -> baseFrame.setPanel1Up());
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
            }

        });

        // registrarBedel
        registrarBedel.setListener(new RegistrarBedel.Listener() {
            @Override
            public void back() {
                alertaConfirmacion.setText("¿Esta seguro que desea cancelar?");
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
                baseFrame.setPanel2Up();

                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                        baseFrame.setPanel1Up();
                        showMenuAdmin();
                    }
                });
            }

            @Override
            public void next() {
                try {
                    String nombre = registrarBedel.getNombre();
                    String apellido = registrarBedel.getApellido();
                    String idLogin = registrarBedel.getIdLogin();
                    TurnoBedel turno = registrarBedel.getTurno();
                    String contraseña = registrarBedel.getContraseña();
                    String rContraseña = registrarBedel.getrContraseña();

                    // rcontraseña
                    if (!contraseña.equals(rContraseña)) {
                        throw new Exceptions.UIException("Las contraseñas no coinciden.");
                    }

                    BedelDTO bedelDTO = new BedelDTO(idLogin, contraseña, nombre, apellido, turno, true);

                    gestorBedel.crear(bedelDTO);

                } catch (Exceptions.UIException | Exceptions.ValueException e) {
                    alerta.setText(e.getMessage());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    return;
                }

                alerta.setText("Bedel registrado con éxito");
                alertaCardLayout.show(alertaPanel, "alerta");
                baseFrame.setPanel2Up();
                alerta.setListener(() -> {
                    baseFrame.setPanel1Up();
                    showMenuAdmin();
                });

            }
        });

        regRsvaSeleccionTipoReserva.setListener(new SeleccionTipoReserva.Listener() {
            @Override
            public void back() {
                showMenuBedel();
            }

            @Override
            public void next() {
                try {
                    Year año = regRsvaSeleccionTipoReserva.getSelectedAño();
                    cuatrimestres = gestorReserva.recuperarCuatrimestresPorAño(año);
                    reserva = new ReservaDTO(-1, null, -1, null, null, -1, null, null, -1, -1, null, false);
                    
                    if (null == regRsvaSeleccionTipoReserva.getSelectedTipoReserva()) {  //esporadica
                        alerta.setText("Seleccione un tipo de reserva");
                        alerta.setListener(() -> baseFrame.setPanel1Up());
                        alertaCardLayout.show(alertaPanel, "alerta");
                        baseFrame.setPanel2Up();
                    } else {
                        switch (regRsvaSeleccionTipoReserva.getSelectedTipoReserva()) {
                            case ANUAL -> {
                                reserva.setEsEsporadica(false);
                                reserva.setTipo(TipoReservaPeriodica.ANUAL);
                                cuat1 = obtenerCuatrimestreActual(cuatrimestres, 1);
                                cuat2 = obtenerCuatrimestreActual(cuatrimestres, 2);
                                if (cuat1 == null || cuat2 == null) {
                                    throw new Exceptions.UIException("<html>No se encontraron cuatrimestres <br>asociados a este año");
                                }
                                if (cuat1.getFechaFin().isBefore(LocalDate.now())){
                                    throw new Exceptions.UIException("<html>No se pueden realizar reservas anuales <br>si el primer cuatrimestre ya termino");
                                }
                                reserva.setIdCuatrimestre1(cuat1.getIdCuatrimestre());
                                reserva.setIdCuatrimestre2(cuat2.getIdCuatrimestre());
                                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                            }
                            case PRIMER_CUATRIMESTRE -> {
                                reserva.setEsEsporadica(false);
                                reserva.setTipo(TipoReservaPeriodica.CUATRIMESTRAL);
                                cuat1 = obtenerCuatrimestreActual(cuatrimestres, 1);
                                if(cuat1.getFechaFin().isBefore(LocalDate.now())) {
                                    throw new Exceptions.UIException("<html>No se puede reservar para <br>un cuatrimestre pasado");
                                }
                                if (cuat1 == null) {
                                    throw new Exceptions.UIException("<html>no se encontraron cuatrimestres <br>asociados al 1er cuatrimestre");
                                }
                                cuatrimestres.clear(); cuatrimestres.add(cuat1);
                                reserva.setIdCuatrimestre1(cuat1.getIdCuatrimestre());
                                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                            }
                            case SEGUNDO_CUATRIMESTRE -> {
                                reserva.setEsEsporadica(false);
                                reserva.setTipo(TipoReservaPeriodica.CUATRIMESTRAL);
                                cuat2 = obtenerCuatrimestreActual(cuatrimestres, 2);
                                if (cuat2 == null) {
                                    throw new Exceptions.UIException("<html>no se encontraron cuatrimestres <br>asociados al 2do cuatrimestre");
                                }
                                cuatrimestres.clear(); cuatrimestres.add(cuat2);
                                reserva.setIdCuatrimestre1(cuat2.getIdCuatrimestre());    //TODO: check
                                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
                            }
                            default -> {
                                //esporadica
                                reserva.setEsEsporadica(true);
                                cardLayout.show(mainPanel, "regAulaEsporadicaDias");
                            }
                        }
                    }
                } catch (DAOException e) {
                    System.out.println(e.getMessage());
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                } catch (Exceptions.UIException e) {
                    System.out.println(e.getMessage());
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                }

            }
        });

        // periodica seleccionar dias
        regRsvaTipoPeriodicaDias.setListener(new TipoPeriodicaDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
            }

            @Override
            public void next() {
                dias = new ArrayList<>(0);

                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[0]) {
                    dias.add(DiaSemana.LUNES);
                }
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[1]) {
                    dias.add(DiaSemana.MARTES);
                }
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[2]) {
                    dias.add(DiaSemana.MIERCOLES);
                }
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[3]) {
                    dias.add(DiaSemana.JUEVES);
                }
                if (regRsvaTipoPeriodicaDias.getDiasSeleccionados()[4]) {
                    dias.add(DiaSemana.VIERNES);
                }

                //gestorReserva.diasSeleccionados(dias);
                regRsvaPeriodicaHorarios.setDiasHabilitados(regRsvaTipoPeriodicaDias.getDiasSeleccionados());
                reserva.setDiasSemana(dias);
                cardLayout.show(mainPanel, "regRsvaPeriodicaHorarios");
            }
        });

        // periodicas seleccionar horarios
        regRsvaPeriodicaHorarios.setListener(new TipoPeriodicaHorarios.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaTipoPeriodicaDias");
            }

            @Override
            public void next() {

                ArrayList<DetalleReservaDTO> detallesDias = new ArrayList<>();
                
                List<Time> horariosInicio = new ArrayList();
                List<Integer> modulos = new ArrayList();
                LocalTime[] horarios = regRsvaPeriodicaHorarios.getHorariosSeleccionados();
                LocalTime[] duraciones = regRsvaPeriodicaHorarios.getDuracionesSeleccionadas();

                if (horarios[0] != null) {

                    DiaSemana ds = DiaSemana.LUNES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[0]);
                    
                    horariosInicio.add(horarioInicio);
                    
                    java.sql.Time time = java.sql.Time.valueOf(duraciones[0]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }
                if (horarios[1] != null) {
                    DiaSemana ds = DiaSemana.MARTES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[1]);
                    
                    horariosInicio.add(horarioInicio);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[1]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }
                if (horarios[2] != null) {
                    DiaSemana ds = DiaSemana.MIERCOLES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[2]);
                    
                    horariosInicio.add(horarioInicio);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[2]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }
                if (horarios[3] != null) {
                    DiaSemana ds = DiaSemana.JUEVES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[3]);

                    horariosInicio.add(horarioInicio);
                    
                    java.sql.Time time = java.sql.Time.valueOf(duraciones[3]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }
                if (horarios[4] != null) {
                    DiaSemana ds = DiaSemana.VIERNES;
                    Time horarioInicio = java.sql.Time.valueOf(horarios[4]);
                    
                    horariosInicio.add(horarioInicio);

                    java.sql.Time time = java.sql.Time.valueOf(duraciones[4]);
                    int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                    int cantModulos = (minutosCompletos / 30);
                    modulos.add(cantModulos);
                    /*DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, null, ds, -1);
                    detallesDias.add(tmp);*/
                }

                /*CuatrimestreDTO cuat;
                listaDetalleReservaDTO = new ArrayList<>();
                for (int i = 0; i < detallesDias.size(); i++) {
                    DetalleReservaDTO detalleDeDia = detallesDias.get(i);

                    if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.PRIMER_CUATRIMESTRE) {
                        listaDetalleReservaDTO.addAll(obtenerDiasCuatrimestre(cuat1, detalleDeDia));
                    } else if (regRsvaSeleccionTipoReserva.getSelected() == SeleccionTipoReserva.TIPO_RESERVA.SEGUNDO_CUATRIMESTRE) {
                        listaDetalleReservaDTO.addAll(obtenerDiasCuatrimestre(cuat2, detalleDeDia));
                    } else {
                        listaDetalleReservaDTO.addAll(obtenerDiasCuatrimestre(cuat1, detalleDeDia));
                        listaDetalleReservaDTO.addAll(obtenerDiasCuatrimestre(cuat2, detalleDeDia));
                    }

                }*/
                
                
                listaDetalleReservaDTO = (ArrayList) gestorReserva.generarDetallesReserva(cuatrimestres, reserva.getDiasSemana(), horariosInicio, modulos);
                
                System.out.println("DetalleReserva generado para reserva periodica: ");
                for(DetalleReservaDTO d : listaDetalleReservaDTO){
                    System.out.println("Fecha: " + d.getFecha() + " - Horario Inicio: " + d.getHorarioInicio() + " - CANT MODULOS: " + d.getCantModulos() + " Dia Semana: " + d.getDiaReserva());
                }
                
                reserva.setDetallesReserva(listaDetalleReservaDTO);
                cardLayout.show(mainPanel, "regRsvaDatos");

            }
        });

        //esporadicaDias
        regAulaEsporadicaDias.setListener(new EsporadicaDias.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
            }

            @Override
            public void next() {

                Object[][] datos = regAulaEsporadicaDias.getData();
                listaDetalleReservaDTO = new ArrayList<>();

                try {
                    for (int i = 0; i < datos.length; i++) {
                        Date dia = (Date) datos[i][0];
                        LocalTime horario = (LocalTime) datos[i][1];
                        LocalTime duracion = (LocalTime) datos[i][2];
                        System.out.println(dia.toString());
                        System.out.println(horario.toString());
                        System.out.println(duracion.toString());

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(dia);

                        DiaSemana ds = DiaSemana.LUNES;
                        int dow = calendar.get(Calendar.DAY_OF_WEEK);

//                        1: Domingo (Calendar.SUNDAY)
//                        2: Lunes (Calendar.MONDAY)
//                        3: Martes (Calendar.TUESDAY)
//                        4: Miércoles (Calendar.WEDNESDAY)
//                        5: Jueves (Calendar.THURSDAY)
//                        6: Viernes (Calendar.FRIDAY)
//                        7: Sábado (Calendar.SATURDAY)
                        if (dow == 2) {
                            ds = DiaSemana.LUNES;
                        } else if (dow == 3) {
                            ds = DiaSemana.MARTES;
                        } else if (dow == 4) {
                            ds = DiaSemana.MIERCOLES;
                        } else if (dow == 5) {
                            ds = DiaSemana.JUEVES;
                        } else if (dow == 6) {
                            ds = DiaSemana.VIERNES;
                        } else {
                            throw new Exceptions.ValueException("no se puede registar una reserva un dia sabado/domingo");
                        }
                        System.out.println(ds.toString());
                        Time horarioInicio = Time.valueOf(horario);
                        Time time = Time.valueOf(duracion);
                        int minutosCompletos = time.toLocalTime().getHour() * 60 + time.toLocalTime().getMinute();

                        int cantModulos = (minutosCompletos / 30);
                        /*
                            idReserva
                            horarioInicio
                            cantModulos
                            fecha
                            diaReserva
                            idAula
                         */
                        LocalDate localDate = dia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        DetalleReservaDTO tmp = new DetalleReservaDTO(-1, horarioInicio, cantModulos, localDate, ds, -1);
                        listaDetalleReservaDTO.add(tmp);
                    }

                    reserva.setDetallesReserva(listaDetalleReservaDTO);
                    
                    gestorReserva.validarDias(listaDetalleReservaDTO, cuatrimestres);
                } catch (ValueException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                }

                cardLayout.show(mainPanel, "regRsvaDatos");
            }
        });

        //registroReservaDatos
        regRsvaDatos.setListener(new RegistrarReservaDatos.Listener() {
            @Override
            public void back() {
                if (reserva.isEsEsporadica()) {
                    cardLayout.show(mainPanel, "regAulaEsporadicaDias");
                } else {
                    boolean d[] = new boolean[] {
                        false,
                        false,
                        false,
                        false,
                        false
                    };
                    if (reserva.getDiasSemana().contains(DiaSemana.LUNES))
                        d[0] = true;
                    if (reserva.getDiasSemana().contains(DiaSemana.MARTES))
                        d[1] = true;
                    if (reserva.getDiasSemana().contains(DiaSemana.MIERCOLES))
                        d[2] = true;
                    if (reserva.getDiasSemana().contains(DiaSemana.JUEVES))
                        d[3] = true;
                    if (reserva.getDiasSemana().contains(DiaSemana.VIERNES))
                        d[4] = true;
                    regRsvaPeriodicaHorarios.setDiasHabilitados(d);
                    cardLayout.show(mainPanel, "regRsvaPeriodicaHorarios");
                }
            }

            @Override
            public void next() {
                String nombreDocente = regRsvaDatos.getNombreDocente();
                String apellidoDocente = regRsvaDatos.getApellidoDocente();
                String nombreCatedra = regRsvaDatos.getNombreCatedra();
                String correo = regRsvaDatos.getCorreo();
                int cantidadAlumnos = regRsvaDatos.getCantidadAlumnos();
                TipoAula tipoAula = regRsvaDatos.getTipoAula();

                try {
                    reserva.setNombreDocente(nombreDocente);
                    reserva.setApellidoDocente(apellidoDocente);
                    reserva.setNombreCatedra(nombreCatedra);
                    reserva.setEmailDocente(correo);
                    reserva.setCantidadAlumnos(cantidadAlumnos);
                    

                    disponibilidadDeAulas = gestorReserva.validarDatosYObtenerAulas(reserva, tipoAula);
                    String[][] datos=convertirFormatoAula(disponibilidadDeAulas);
                    regRsvaAula.setTable(datos);

                } catch (ValueException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                } catch (Exceptions.NoExisteAulaException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                } catch (DAOException e) {
                    alerta.setText("<html>no se pudo seleccionar el aula<br>Ocurrio un error en la base de datos");
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    // deberia volver al menu?
                    return;
                }
                if(disponibilidadDeAulas.getSolapamiento()){
                HashMap<DetalleReservaDTO,AulaDTO> aulas= new HashMap();
                List<ReservaDTO> reservas= new ArrayList();
                System.out.println("DETALLES RESERVA SOLAPADOS X DIA");
                for(DetalleReservaDTO dr : disponibilidadDeAulas.getDrSolapados()){
                AulaDTO aula = disponibilidadDeAulas.getAulasDisponibles().get(dr.getIdAula());
                aulas.put(dr, aula);
                ReservaDTO reserva = disponibilidadDeAulas.getReservasSolapadas().get(dr.getIdReserva());
                reservas.add(reserva);
                System.out.println("fecha: " + dr.getFecha() + " - aula: "  + aula.getUbicacion()  + " - catedra: " + reserva.getNombreCatedra());
            }
            showReservasSolapadas(aulas,reservas);
                }
                else{
                    System.out.println(disponibilidadDeAulas.getSolapamiento());
                    regRsvaAula.setTitle("Seleccione su aula a reservar");
                cardLayout.show(mainPanel, "regRsvaAula");
                }
            }
        });

        //registroResultadosAulas
        regRsvaAula.setListener(new ResultadosAulas.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaDatos");
            }

            @Override
            public void next() {
                int idx = regRsvaAula.getSelectedElementIndex();

                /*  idReserva           -
                    nombreDocente       *
                    idDocente           ?
                    apellidoDocente     *
                    emailDocente        *
                    idCatedra           ?
                    nombreCatedra       *
                    fechaRegistro       now()
                    cantidadAlumnos     *
                    idBedel             0
                    tipo                0
                    diasSemana          0
                    esEsporadica        0
                    idCuatrimestre1     0
                    idCuatrimestre2     0
                    detallesReserva     0
                 */
                //nombreDocente, apellidoDocente, correo, nombreCatedra, cantidadAlumnos
                //AulaDTO aula = disponibilidadDeAulas.getAulasDisponibles().get(idx);
                List<AulaDTO> aulasDisponibles = new ArrayList<>(disponibilidadDeAulas.getAulasDisponibles().values());
                AulaDTO aula = aulasDisponibles.get(idx);
                /* estos 2 ya se hacen desde el gestor/dao
                    reserva.setFechaRegistro(LocalDateTime.now());
                    reserva.setIdBedel(idBedel); 
                */

                /*
                idReserva
                horarioInicio
                cantModulos
                fecha
                diaReserva
                idAula
                 */
                for (int i = 0; i < listaDetalleReservaDTO.size(); i++) {
                    listaDetalleReservaDTO.get(i).setIdAula(aula.getIdAula());
                }
                
                reserva.setDetallesReserva(listaDetalleReservaDTO);
                
                try {
                    gestorReserva.crearReserva(reserva);

                    alerta.setText("reserva realizada con exito");
                    alerta.setListener(() -> {
                        showMenuBedel();
                        baseFrame.setPanel1Up();
                    });
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();

                    regRsvaSeleccionTipoReserva.resetInterface();
                    regRsvaTipoPeriodicaDias.resetInterface();
                    regRsvaPeriodicaHorarios.resetInterface();
                    regRsvaDatos.resetInterface();
                    regAulaEsporadicaDias.resetInterface();

                } catch (DAOException e) {
                    alerta.setText("<html>no se pudo realizar la reserva<br>ocurrio un error en la base de datos");
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                } catch (ValueException ex) {
                    // esta excepcion se tiraria si al buscar el bedel que crea la reserva con gestorBedel.buscarPorId() 
                    // (en la funcion crearReserva->convertirAModelo) el bedel NO existe, esto no deberia pasar nunca.
                    alerta.setText("<html>no se pudo realizar la reserva<br>ocurrió un error al obtener el bedel logueado");
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                }
            }
        });
        
        reservasSolapadas.setListener(new ReservasSolapadas.Listener() {
            @Override
            public void back() {
                cardLayout.show(mainPanel, "regRsvaDatos");
            }

            @Override
            public void next(){
                baseFrame.setPanel1Up();
            }
            
            @Override
            public void menu() {
                alertaConfirmacion.setText("¿Esta seguro que desea regresar al menu?");

                alertaConfirmacion.setListener(new AlertaConfirmacion.Listener() {
                    @Override
                    public void back() {
                        baseFrame.setPanel1Up();
                    }

                    @Override
                    public void next() {
                    showMenuBedel();
                    }
                });
                baseFrame.setPanel2Up();
                alertaCardLayout.show(alertaPanel, "alertaConfirmacion");
            }
        });

    }

    private void showLogin() {
        cardLayout.show(mainPanel, "login");
    }

    private void showMenuAdmin() {
        cardLayout.show(mainPanel, "menuAdmin");
    }

    private void showBuscarBedel() {
        cardLayout.show(mainPanel, "buscarBedel");
    }

    public void showResultadosBusquedaBedel(List<BedelDTO> bedeles) {
        resultadosBusquedaBedel.updateBedeles(bedeles);
        cardLayout.show(mainPanel, "resultadosBusquedaBedel");
    }

    private void showRegistrarBedel() {

        cardLayout.show(mainPanel, "registrarBedel");
    }

    // Reserva
    private void showMenuBedel() {
        menuBedel.setListener(new MenuBedel.Listener() {
            @Override()
            public void back() {
                gestorLogin.cerrarSesion();
                showLogin();
            }
            @Override
            public void registrarReserva() {
                try {
                    showRegistrarReserva();
                } catch (Exceptions.UIException e) {
                    alerta.setText(e.getMessage());
                    alerta.setListener(() -> baseFrame.setPanel1Up());
                    alertaCardLayout.show(alertaPanel, "alerta");
                    baseFrame.setPanel2Up();
                    return;
                }
            }

            @Override
            public void buscarAulas() {
            }

            @Override
            public void listarReservasParaUnCurso() {

            }

            @Override
            public void listarReservasParaUnDia() {

            }
        });
        cardLayout.show(mainPanel, "menuBedel");
    }

    private void showRegistrarReserva() throws Exceptions.UIException {
        try {
            // obtiene la lista de años disponibles para los que se puede reservar.
            regRsvaSeleccionTipoReserva.setListaAños(gestorReserva.recuperarAñosDisponibles());
        } catch (DAOException ex) {
            throw new Exceptions.UIException("Error al recuperar los años disponibles para reservar");
        }
        cardLayout.show(mainPanel, "regRsvaSeleccionTipoReserva");
        
    }
        public void showReservasSolapadas(HashMap<DetalleReservaDTO,AulaDTO> aulas,List<ReservaDTO> reservas) {
        reservasSolapadas.setReservas(reservas);
        reservasSolapadas.updateAulas(aulas);
        cardLayout.show(mainPanel, "reservasSolapadas");
    }

    private String[][] convertirFormatoAula(DisponibilidadDTO disp) {
        // SI EXISTEN AULAS SIN SOLAPAMIENTO
        if (!disp.getSolapamiento()) {
            List<AulaDTO> aulasDisponibles = new ArrayList<>(disp.getAulasDisponibles().values());

            String[][] str = new String[aulasDisponibles.size()][];
            
            Iterator<AulaDTO> it = aulasDisponibles.iterator();
            int i = 0;
            while (it.hasNext()) {
                // TODO: sacar tipo (solo se debe mostrar la ubicacion creo, verificar) 
                AulaDTO auladto = it.next();
                String ubicacion = auladto.getUbicacion();
                String capacidad = auladto.getCapacidad() + " personas";
                /*int modulosSolapados = aulasDisponibles.get(auladto);
            int modulosTotales = disp.getCantidadModulosTotales();
            String solap = String.format("%.0f%%", ((float) modulosSolapados / modulosTotales) * 100);
            //String solap = (((float) modulosSolapados / (float)modulosTotales) * 100) + "%";*/

                List<String> caracteristics = new ArrayList<>();
                if (auladto.isAireAcondicionado()) {
                    caracteristics.add("aire acondicionado");
                }
                if (auladto.isCanon()) {
                    caracteristics.add("cañon");
                }
                if (auladto.isComputadora()) {
                    caracteristics.add("computadoras");
                }
                if (auladto.isTelevisor()) {
                    caracteristics.add("televisor");
                }
                if (auladto.isVentiladores()) {
                    caracteristics.add("ventiladores");
                }
                String caracteristicas = "";
                for (int j = 0; j < caracteristics.size(); j++) {
                    caracteristicas += caracteristics.get(j);
                    if (j != caracteristics.size() - 1) {
                        caracteristicas += " / ";
                    }
                }

                str[i] = new String[]{ubicacion, capacidad, caracteristicas/*, solap*/};
                i++;
            }
            return str;
        }
        
        // SI NO EXISTEN AULAS SIN SOLAPAMIENTO
        // hay q manejar la lista de DR solapados, y el hashMap de aulas y Reservas (estos 2 hashmap son para obtener los datos necesarios de c/u)
        // para cada DR de la lista, hay q mostrar: ubicación aula (atributo aula), fecha, horario inicio, horario fin, datos de contacto (atributos reserva)
        else return null;
    }

    private CuatrimestreDTO obtenerCuatrimestreActual(List<CuatrimestreDTO> cuats, int numofcuat) {
        if (cuats == null || cuats.size() == 0) {
            return null;
        }
        int yearNow = LocalDate.now().getYear();

        for (int i = 0; i < cuats.size(); i++) {
            CuatrimestreDTO cuat = cuats.get(i);
            // buscar en cuatrimestres de este año
            
                if (cuat.getFechaInicio().getMonthValue() < 6 && numofcuat == 1) {
                    return cuat;
                } else if (cuat.getFechaInicio().getMonthValue() >= 6 && numofcuat == 2) {
                    return cuat;
                }
            
        }
        return null;
    }

    private List<DetalleReservaDTO> obtenerDiasCuatrimestre(CuatrimestreDTO cuat, DetalleReservaDTO detalleDeDia) {
        LocalDate fin = cuat.getFechaFin();

        LocalDate iterator = cuat.getFechaFin();
        DayOfWeek dow = diaSemana2DawOfWeek(detalleDeDia.getDiaReserva());
        System.out.println(dow.toString());
        while (iterator.getDayOfWeek() != diaSemana2DawOfWeek(detalleDeDia.getDiaReserva())) {
            iterator = iterator.plusDays(1);
            System.out.println(iterator.toString());
        }

        List<DetalleReservaDTO> detalles = new ArrayList<>();

        while (iterator.isBefore(fin) || iterator.equals(fin)) {
            System.out.println(iterator.toString());
            /*
            idReserva
            horarioInicio
            cantModulos
            fecha
            diaReserva
            idAula
             */
            DetalleReservaDTO detalle = new DetalleReservaDTO(
                    -1,
                    detalleDeDia.getHorarioInicio(),
                    detalleDeDia.getCantModulos(),
                    iterator,
                    detalleDeDia.getDiaReserva(),
                    detalleDeDia.getIdAula()
            );
            detalles.add(detalle);
            iterator = iterator.plusDays(7);

        }

        return detalles;
    }

    private DayOfWeek diaSemana2DawOfWeek(DiaSemana d) {
        if (d == DiaSemana.LUNES) {
            return DayOfWeek.MONDAY;
        } else if (d == DiaSemana.MARTES) {
            return DayOfWeek.THURSDAY;
        } else if (d == DiaSemana.MIERCOLES) {
            return DayOfWeek.WEDNESDAY;
        } else if (d == DiaSemana.JUEVES) {
            return DayOfWeek.TUESDAY;
        } else if (d == DiaSemana.VIERNES) {
            return DayOfWeek.FRIDAY;
        } else {
            return null;
        }
    }

}

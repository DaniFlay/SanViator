import java.util.ArrayList;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LectorSAX extends DefaultHandler {
	private String textoLeido;
	private String ratingName;
	private String titulo;
	private String tituloOriginal;
	private double puntuacion;
	private int anyo;
	private Pelicula pelicula=null;
	private ArrayList<Pelicula> peliculas= new ArrayList<Pelicula>();
	
	public String getTextoLeido() {
		return textoLeido;
	}

	public void setTextoLeido(String textoLeido) {
		this.textoLeido = textoLeido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equals("movie")) {
				pelicula= new Pelicula();
			}
				if(qName.equals("rating")) {
					ratingName=attributes.getValue("name");
				}
			}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("title")) {
			pelicula.setTitulo(textoLeido);
		}
		else if(qName.equals("originaltitle")) {
			pelicula.setTituloOriginal(textoLeido);
		}
		else if(qName.equals("value")&&ratingName.equals("themoviedb")) {
			pelicula.setPunutacion(Double.parseDouble(textoLeido));
		}
		else if(qName.equals("year")) {
			pelicula.setAnyo(Integer.parseInt(textoLeido));
		}
		else if(qName.equals("movie")) {
			peliculas.add(pelicula);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		textoLeido= new String(ch, start, length);
	}


	}
	



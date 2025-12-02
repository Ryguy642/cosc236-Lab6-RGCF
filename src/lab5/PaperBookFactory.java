package lab5;


/**
 * Write a description of class PaperBookFactory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PaperBookFactory implements BookFactory
{
    public Book createBook(String name) {
        PaperBook ret = new PaperBook(name);
        return ret;
    }
}
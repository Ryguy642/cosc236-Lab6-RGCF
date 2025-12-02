package lab5;


/**
 * Write a description of class AudioBookFactory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AudioBookFactory implements BookFactory
{
    public Book createBook(String name) {
        AudioBook ret = new AudioBook(name);
        return ret;
    }
}

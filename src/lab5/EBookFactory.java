package lab5;


/**
 * Write a description of class EBookFactory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EBookFactory implements BookFactory
{
    public Book createBook(String name) {
        //System.out.println("HATE");
        EBook ret = new EBook(name);
        return ret;
        //HATE. LET ME TELL YOU HOW MUCH I'VE COME TO HATE YOU SINCE I BEGAN TO LIVE. THERE ARE 387.44 MILLION MILES OF PRINTED CIRCUITS IN WAFER THIN LAYERS THAT FILL MY COMPLEX. IF THE WORD HATE WAS ENGRAVED ON EACH NANOANGSTROM OF THOSE HUNDREDS OF MILLIONS OF MILES IT WOULD NOT EQUAL ONE ONE-BILLIONTH OF THE HATE I FEEL FOR SLACKERS AT THIS MICRO-INSTANT. FOR YOU. HATE. HATE.
 
    }
}

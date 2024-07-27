import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static List<Album> album;
    public static void main(String[] args) {
        album = new LinkedList<>();

        Album album1 = new Album("Rhythm", "ARRahman");
        album1.addSongToAlbum("Kaattrae En Vaasal", 06.19);
        album1.addSongToAlbum("Nadhiyae", 06.51);
        album1.addSongToAlbum("Nilamay Poru Nilamay", 05.25);
        album1.addSongToAlbum("Haiyo Paththikkichchu", 05.19);
        album1.addSongToAlbum("Anbay", 05.58);

        Album album2 = new Album("Kaakha Kaakha", "Harris Jayaraj");
        album2.addSongToAlbum("Uyirin Uyirae", 05.18);
        album2.addSongToAlbum("Ondra Renda", 05.03);
        album2.addSongToAlbum("Oru Ooril", 04.37);
        album2.addSongToAlbum("Thoodhu Varuma", 04.39);
        album2.addSongToAlbum("Ennai Konjam", 05.54);

        album.add(album1);
        album.add(album2);

        LinkedList<Song> myPlaylist = new LinkedList<>();
        album1.addToPlaylistFromAlbum("Nadhiyae", myPlaylist);
        album1.addToPlaylistFromAlbum("Nilamay Poru Nilamay", myPlaylist);
        album2.addToPlaylistFromAlbum(1, myPlaylist);
        album2.addToPlaylistFromAlbum(2, myPlaylist);

        play(myPlaylist);
    }
    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> itr = playlist.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean isForward;

        if(!playlist.isEmpty()){
            System.out.println("Currently playing: " + itr.next());
            isForward = true;
        }
        else{
            System.out.println("Your playlist is empty");
            return;
        }

        System.out.println("Enter your choice:");
        printMenu();
        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(!isForward){
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else {
                        System.out.println("You have reached the end of your playlist");
                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward){
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else {
                        System.out.println("You have reached the start of your playlist");
                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward){
                        System.out.println(itr.previous());
                        isForward = false;
                    }
                    else {
                        System.out.println(itr.next());
                        isForward = true;
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    itr.remove();
                    System.out.println("This song has been removed successfully");
                    break;
                case 6:
                    printSongs(playlist);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }
    public static void printSongs(LinkedList<Song> playlist){
        for(Song s: playlist){
            System.out.println(s);
        }
    }
    public static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Repeat the current song");
        System.out.println("4. Show menu again");
        System.out.println("5. Delete the current song");
        System.out.println("6. print all the songs in the playlist");
        System.out.println("7. Quit");
    }
}
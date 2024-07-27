import java.util.*;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Song findSong(String title){
        for(Song s: songs){
            if(s.getTitle().equals(title)) return s;
        }
        return null;
    }

    public void addSongToAlbum(String title, double duration){
        Song s = new Song(title, duration);
        if(findSong(title) != null){
            System.out.println("This song is already present in the album");
        }
        else {
            songs.add(s);
            System.out.println("This song has been successfully added to the album");
        }
    }

    //polymorphism
    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playlist){
        Song s = findSong(title);
        if( s != null){
            playlist.add(s);
            System.out.println("This song has been added to your playlist successfully");
        }
        else {
            System.out.println("This song is not present in the album");
        }
    }
    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playlist){
        int albumSize = songs.size();
        int idx = trackNo - 1;
        if(trackNo > 0 && trackNo <= albumSize){
            playlist.add(songs.get(idx));
            System.out.println("This song has been added to your playlist successfully");
        }
        else {
            System.out.println("This song is not present in the album");
        }
    }
}

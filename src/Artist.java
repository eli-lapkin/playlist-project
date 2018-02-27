import java.util.ArrayList;
public class Artist {
    private String artistName;
    private ArrayList<Song> songs;

    public Artist(String name) {
      artistName = name;
    }

    public void addSong(String song) {
      Song s = new Song(this, song);
      songs.add(s);
    }

    public String toString() {
      String result = "[Artist Name: " + artistName + ", Songs: " + songs + "]";
      return result;
    }

    public boolean equals(Artist other) {
      return artistName.equals(other.artistName);
    }

    public ArrayList<Song> getSongs() {
      return songs;
    }

    public String getName() {
      return artistName;
    }
}

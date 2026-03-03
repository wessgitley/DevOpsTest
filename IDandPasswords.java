import java.util.HashMap;

public class IDandPasswords {

  HashMap<String, String> Loginfo = new HashMap<String, String>();

  IDandPasswords() {
    Loginfo.put("wes", "potatoes");
    Loginfo.put("dave", "chicken");
    Loginfo.put("brian", "beans");
  }

  protected HashMap<String, String> getLoginfo() {
    return Loginfo;
  }

}

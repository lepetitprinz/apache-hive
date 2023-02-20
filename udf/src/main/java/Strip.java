import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.hive.ql.exec.Description;

@Description(
    name = "Strip",
    value = "returns a stripped text",
    extended = "stripping characters from the ends of strings"
)
public class Strip extends UDF {
    private Text result = new Text();
    public Text evaluate(Text str){
        if (str == null){
            return null;
        }
        result.set(StringUtils.strip(str.toString()));
        return result;
    }
    public Text evaluate(Text str, String stripChar){
        if (str == null){
            return null;
        }
        result.set(StringUtils.strip(str.toString(), stripChar));
        return result;
    }
}
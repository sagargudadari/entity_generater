import org.apache.commons.text.WordUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EntityGenerator {

    public static void main(String[] args) throws Exception{
        String path = "D:\\data_files_entity\\gcms_tran_column.csv";

        List<String> lines = Files.readAllLines(Paths.get(path));
        final char [] delimeter = {'_'};
        lines.forEach(line-> {
            String [] col = line.split(",");
            String colModi = col[0];
            //System.out.println("@Column(name=\""+colModi+"\")");
            StringBuilder str = new StringBuilder(WordUtils.capitalizeFully(colModi,delimeter).replace("_",""));
            str.setCharAt(0,Character.toLowerCase(str.charAt(0)));
           String access = col[1].contains("VARCHAR")?"String":"BigDecimal";
            System.out.println("private "+access+" "+str+";\n");
        });
    }
}

package map.struct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-16T13:39:49+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ConverterImpl implements Converter {

    @Override
    public B aToB(A car) {
        if ( car == null ) {
            return null;
        }

        B b = new B();

        b.setName( car.getName() );
        b.setIds( integerListToStringList( car.getIds() ) );

        return b;
    }

    protected List<String> integerListToStringList(List<Integer> list) {
        if ( list == null ) {
            return null;
        }

        List<String> list1 = new ArrayList<String>( list.size() );
        for ( Integer integer : list ) {
            list1.add( String.valueOf( integer ) );
        }

        return list1;
    }
}

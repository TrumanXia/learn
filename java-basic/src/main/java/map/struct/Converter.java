package map.struct;

/**
 * @author xiayiguo
 * @since 2021-05-16
 */

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Converter {
    Converter INSTANCE = Mappers.getMapper(Converter.class);

    B aToB(A car);
}
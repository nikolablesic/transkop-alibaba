package transkop.tracking.utils.generators;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import transkop.tracking.utils.convertors.DecimalConverter;

import java.io.Serializable;
import java.util.Properties;

import static transkop.tracking.utils.convertors.DecimalConverter.toDotriacontatetra;

public class HexadecimalSequenceIdGenerator extends SequenceStyleGenerator {

    public static final String LENGTH_PARAM = "numberLength";
    public static final String LENGTH_DEFAULT = "8";
    private int numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session,
                                 Object object) throws HibernateException {
        Long decimalId = (Long) super.generate(session, object);
        String convertedId = toDotriacontatetra(decimalId);
        return String.format("%1$" + numberFormat + "s", convertedId).replace(' ', '0');
    }

    @Override
    public void configure(Type type, Properties params,
                          ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        numberFormat = Integer.parseInt(ConfigurationHelper.getString(LENGTH_PARAM,
                params, LENGTH_DEFAULT));
    }

}

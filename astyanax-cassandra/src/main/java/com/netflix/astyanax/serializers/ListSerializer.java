package com.netflix.astyanax.serializers;

import java.nio.ByteBuffer;
import java.util.List;

import org.apache.cassandra.db.marshal.AbstractType;
import org.apache.cassandra.db.marshal.ListType;

import com.netflix.astyanax.serializers.AbstractSerializer;

public class ListSerializer<T> extends AbstractSerializer<List<T>> {

    
    ListType<T> myList;

    public ListSerializer(AbstractType<T> elements) {
        myList = ListType.getInstance(elements);
    }
    
    @Override
    public List<T> fromByteBuffer(ByteBuffer arg0) {
        List<T> result = arg0 == null ? null : myList.compose(arg0);
        return result;
    }

    @Override
    public ByteBuffer toByteBuffer(List<T> arg0) {
        ByteBuffer result = arg0 == null ? null : myList.decompose(arg0);
        return result;
    }
}
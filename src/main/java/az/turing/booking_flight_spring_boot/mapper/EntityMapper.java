package az.turing.booking_flight_spring_boot.mapper;


import java.util.List;

public interface EntityMapper<E,D> {

    E toEntity(D d);

    D toDto(E e);

    List<E> toListEntity(List<D> d);

    List<D> toListDto(List<E> e);
}

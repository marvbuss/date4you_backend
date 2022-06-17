package com.tutego.date4you;

import com.tutego.date4you.service.PhotoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(properties = "spring.shell.interactive.enabled=false")
class Date4youApplicationTests {

    @Autowired
    PhotoService photoService;

    @Test
    void contextLoads() {
    }

//    @Nested
//    class Validator {
//        @Test
//        void photo_is_valid() {
//            Photo photo = new Photo( 1L, 1L, "fillmorespic", false, LocalDateTime.now().minusDays( 1 ) );
//            assertThatCode( () -> photoService.download( photo ) ).doesNotThrowAnyException();
//        }
//
//        @Test
//        void photo_has_invalid_birthdate() {
//            Photo photo = new Photo( 1L, 1L, "fillmorespic", false, LocalDateTime.of( 2500, 1, 1, 0, 0, 0 ) );
//            assertThatThrownBy( () -> photoService.download( photo ) )
//                    .isInstanceOf( ConstraintViolationException.class )
//                    .extracting( throwable -> ((ConstraintViolationException) throwable).getConstraintViolations(),
//                            as( InstanceOfAssertFactories.collection( ConstraintViolation.class ) ) )
//                    .hasSize( 1 )
//                    .element( 0, as( InstanceOfAssertFactories.type( ConstraintViolation.class ) ) )
//                    .satisfies( constraintViolation -> {
//                        assertThat( constraintViolation.getRootBeanClass() ).isSameAs( PhotoService.class );
//                        assertThat( constraintViolation.getLeafBean() ).isExactlyInstanceOf( Photo.class );
//                        assertThat( constraintViolation.getPropertyPath() ).hasToString( "download.photo.created" );
//                        assertThat( constraintViolation.getInvalidValue() ).isEqualTo( LocalDateTime.of( 2500, 1, 1, 0, 0, 0 ) );
//                        assertThat( constraintViolation.getMessage() ).isEqualTo( "muss ein Datum in der Vergangenheit sein" );
//                    } );
//        }
//    }

}

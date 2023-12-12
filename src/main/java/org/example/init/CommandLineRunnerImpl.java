package org.example.init;

import org.example.models.enums.EngineType;
import org.example.models.enums.ModelCategory;
import org.example.models.enums.TransmissionType;
import org.example.models.enums.UserRoleType;
import org.example.services.*;
import org.example.services.dtos.input.*;
import org.example.services.dtos.output.BrandModelCountDTO;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private OfferService offerService;

    @Transactional
    public void createData() {

        BrandDTO brand1 = brandService.createCarBrand("Toyota");
        BrandDTO brand2 = brandService.createCarBrand("BMW");
        BrandDTO brand3 = brandService.createCarBrand("Audi");
        BrandDTO brand4 = brandService.createCarBrand("Mercedes-Benz");
        BrandDTO brand5 = brandService.createCarBrand("Ford");
        BrandDTO brand6 = brandService.createCarBrand("Honda");
        BrandDTO brand7 = brandService.createCarBrand("Nissan");
        BrandDTO brand8 = brandService.createCarBrand("Chevrolet");
        BrandDTO brand9 = brandService.createCarBrand("Volkswagen");
        BrandDTO brand10 = brandService.createCarBrand("Hyundai");
        BrandDTO brand11 = brandService.createCarBrand("Kia");
        BrandDTO brand12 = brandService.createCarBrand("Subaru");
        BrandDTO brand13 = brandService.createCarBrand("Lexus");
        BrandDTO brand14 = brandService.createCarBrand("Mazda");
        BrandDTO brand15 = brandService.createCarBrand("Porsche");
        BrandDTO brand16 = brandService.createCarBrand("Jaguar");
        BrandDTO brand17 = brandService.createCarBrand("Land Rover");
        BrandDTO brand18 = brandService.createCarBrand("Tesla");
        BrandDTO brand19 = brandService.createCarBrand("Acura");
        BrandDTO brand20 = brandService.createCarBrand("Volvo");

        String model1 = modelService.createCarModel(new ModelDTO("Camry", ModelCategory.CAR, "imageUrl1", 1990, 2021, brand1.getId())).getId();
        String model2 = modelService.createCarModel(new ModelDTO("X5", ModelCategory.TRUCK, "imageUrl2", 2000, 2021, brand2.getId())).getId();
        String model3 = modelService.createCarModel(new ModelDTO("Corolla", ModelCategory.CAR, "imageUrl3", 1995, 2021, brand1.getId())).getId();
        String model4 = modelService.createCarModel(new ModelDTO("A4", ModelCategory.CAR, "imageUrl4", 1998, 2021, brand3.getId())).getId();
        String model5 = modelService.createCarModel(new ModelDTO("E-Class", ModelCategory.CAR, "imageUrl5", 2001, 2021, brand4.getId())).getId();
        String model6 = modelService.createCarModel(new ModelDTO("Focus", ModelCategory.CAR, "imageUrl6", 2003, 2021, brand5.getId())).getId();
        String model7 = (modelService.createCarModel(new ModelDTO("Civic", ModelCategory.CAR, "imageUrl7", 2005, 2021, brand6.getId()))).getId();
        String model8 = modelService.createCarModel(new ModelDTO("Altima", ModelCategory.CAR, "imageUrl8", 2008, 2021, brand7.getId())).getId();
        String model9 = modelService.createCarModel(new ModelDTO("Cruze", ModelCategory.CAR, "imageUrl9", 2010, 2021, brand8.getId())).getId();
        String model10 = modelService.createCarModel(new ModelDTO("Jetta", ModelCategory.CAR, "imageUrl10", 2012, 2021, brand9.getId())).getId();
        String model11 = modelService.createCarModel(new ModelDTO("Elantra", ModelCategory.CAR, "imageUrl11", 2014, 2021, brand10.getId())).getId();
        String model12 = modelService.createCarModel(new ModelDTO("Sorento", ModelCategory.CAR, "imageUrl12", 2016, 2021, brand11.getId())).getId();
        String model13 = modelService.createCarModel(new ModelDTO("Outback", ModelCategory.CAR, "imageUrl13", 2018, 2021, brand12.getId())).getId();
        String model14 = modelService.createCarModel(new ModelDTO("RX 350", ModelCategory.CAR, "imageUrl14", 2020, 2021, brand13.getId())).getId();
        String model15 = modelService.createCarModel(new ModelDTO("CX-5", ModelCategory.CAR, "imageUrl15", 2022, 2021, brand14.getId())).getId();
        String model16 = modelService.createCarModel(new ModelDTO("911", ModelCategory.CAR, "imageUrl16", 2024, 2021, brand15.getId())).getId();
        String model17 = modelService.createCarModel(new ModelDTO("F-PACE", ModelCategory.CAR, "imageUrl17", 2026, 2021, brand16.getId())).getId();
        String model18 = modelService.createCarModel(new ModelDTO("Range Rover Sport", ModelCategory.CAR, "imageUrl18", 2028, 2021, brand17.getId())).getId();
        String model19 = modelService.createCarModel(new ModelDTO("Model S", ModelCategory.CAR, "imageUrl19", 2030, 2021, brand18.getId())).getId();
        String model20 = modelService.createCarModel(new ModelDTO("XC60", ModelCategory.CAR, "imageUrl20", 2032, 2021, brand19.getId())).getId();

        UserRoleDTO userRole = userRoleService.createUserRole(new UserRoleDTO(UserRoleType.USER));
        UserRoleDTO adminRole = userRoleService.createUserRole(new UserRoleDTO(UserRoleType.ADMIN));

        String user1 = userService.createUser(new UserDTO("user", "user", "User3", "Doe", true, "/images/users/ladyBag.jpg")).getId();
        String user2 = userService.createUser(new UserDTO("username4", "password4", "User4", "Doe", true, "/images/users/mrPs.jpg")).getId();
        String user3 = userService.createUser(new UserDTO("Never", "123456", "Rick", "Astley", true, "/images/users/rickAstley.jpg")).getId();
        String user4 = userService.createUser(new UserDTO("username6", "password6", "User6", "Doe", false, "userImageUrl6")).getId();
        String user5 = userService.createUser(new UserDTO("username7", "password7", "User7", "Doe", true, "userImageUrl7")).getId();
        String user6 = userService.createUser(new UserDTO("username8", "password8", "User8", "Doe", true, "userImageUrl8")).getId();
        String user7 = userService.createUser(new UserDTO("username9", "password9", "User9", "Doe", true, "userImageUrl9")).getId();
        String user8 = userService.createUser(new UserDTO("username10", "password10", "User10", "Doe", true, "userImageUrl10")).getId();
        String user9 = userService.createUser(new UserDTO("username11", "password11", "User11", "Doe", false, "userImageUrl11")).getId();
        String user10 = userService.createUser(new UserDTO("username12", "password12", "User12", "Doe", true, "userImageUrl12")).getId();
        String user11 = userService.createUser(new UserDTO("username13", "password13", "User13", "Doe", true, "userImageUrl13")).getId();
        String user12 = userService.createUser(new UserDTO("username14", "password14", "User14", "Doe", true, "userImageUrl14")).getId();
        String user13 = userService.createUser(new UserDTO("username15", "password15", "User15", "Doe", true, "userImageUrl15")).getId();
        String user14 = userService.createUser(new UserDTO("username16", "password16", "User16", "Doe", false, "userImageUrl16")).getId();
        String user15 = userService.createUser(new UserDTO("username17", "password17", "User17", "Doe", true, "userImageUrl17")).getId();
        String user16 = userService.createUser(new UserDTO("username18", "password18", "User18", "Doe", true, "userImageUrl18")).getId();
        String user17 = userService.createUser(new UserDTO("username19", "password19", "User19", "Doe", true, "userImageUrl19")).getId();
        String user18 = userService.createUser(new UserDTO("username20", "password20", "User20", "Doe", true, "userImageUrl20")).getId();
        String admin = userService.createUser(new UserDTO("admin", "admin", "Admin", "Admin", true, "adminImageUrl", UserRoleType.ADMIN)).getId();

//        for (int i = 0; i < 10000; i++) {
//            String username = "username" + (i + 21);
//            String password = "password" + (i + 21);
//            String firstName = "User" + (i + 21);
//            String lastName = "Doe" + (i + 21);
//            boolean active = i % 2 == 0;
//            String imageUrl = "userImageUrl" + (i + 21);
//
//            userService.createUser(new UserDTO(username, password, firstName, lastName, active, imageUrl)).getId();
//        }

        OfferDTO offerDTO1 = offerService.createOffer(new OfferDTO("Все автомобили, представленные в продаже, проходят диагностику по всем параметрам, с результатами диагностики Вы можете ознакомиться при осмотре автомобиля."
                , EngineType.GASOLINE, "/images/offers/ToyotaCamry2019.png", 81341, new BigDecimal("2399000.00"), TransmissionType.AUTOMATIC, 2019, model1, user1));
        OfferDTO offerDTO2 = offerService.createOffer(new OfferDTO("Распродажа, финальный sale!\n\uD83D\uDCA5Гарантия 2 ГОДА или 100 000км пробега на ВСЕ НОВЫЕ автомобили BMW в РОЛЬФ Премиум Вешки!\uD83D\uDCA5"
                , EngineType.DIESEL, "/images/offers/BMWX52023.png", 0, new BigDecimal("15850000.00"), TransmissionType.AUTOMATIC, 2023, model2, user2));
        OfferDTO offerDTO3 = offerService.createOffer(new OfferDTO("Обслуживалась у официалов.\nПробег родной. Один хозяин.\nВ наличии комплект летней резины на дисках. Сигнализация с автозапуском."
                , EngineType.GASOLINE, "/images/offers/ToyotaCorolla2013.png", 101000, new BigDecimal("1500000.00"), TransmissionType.MANUAL, 2013, model3, admin));
        OfferDTO offerDTO4 = offerService.createOffer(new OfferDTO("Description4", EngineType.GASOLINE, "offerImageUrl4", 55000, new BigDecimal("10500.00"), TransmissionType.AUTOMATIC, 2017, model4, user3));
        OfferDTO offerDTO5 = offerService.createOffer(new OfferDTO("Description5", EngineType.DIESEL, "offerImageUrl5", 62000, new BigDecimal("15500.00"), TransmissionType.MANUAL, 2018, model5, user4));
        OfferDTO offerDTO6 = offerService.createOffer(new OfferDTO("Description6", EngineType.GASOLINE, "offerImageUrl6", 59000, new BigDecimal("11000.00"), TransmissionType.AUTOMATIC, 2016, model6, user5));
        OfferDTO offerDTO7 = offerService.createOffer(new OfferDTO("Description7", EngineType.DIESEL, "offerImageUrl7", 68000, new BigDecimal("16000.00"), TransmissionType.MANUAL, 2015, model7, user6));
        OfferDTO offerDTO8 = offerService.createOffer(new OfferDTO("Description8", EngineType.GASOLINE, "offerImageUrl8", 51000, new BigDecimal("10000.00"), TransmissionType.AUTOMATIC, 2013, model8, user7));
        OfferDTO offerDTO9 = offerService.createOffer(new OfferDTO("Description9", EngineType.DIESEL, "offerImageUrl9", 63000, new BigDecimal("15000.00"), TransmissionType.MANUAL, 2012, model9, user8));
        OfferDTO offerDTO10 = offerService.createOffer(new OfferDTO("Description10", EngineType.GASOLINE, "offerImageUrl10", 57000, new BigDecimal("11500.00"), TransmissionType.AUTOMATIC, 2010, model10, user9));
        OfferDTO offerDTO11 = offerService.createOffer(new OfferDTO("Description11", EngineType.DIESEL, "offerImageUrl11", 61000, new BigDecimal("15500.00"), TransmissionType.MANUAL, 2008, model11, user10));
        OfferDTO offerDTO12 = offerService.createOffer(new OfferDTO("Description12", EngineType.GASOLINE, "offerImageUrl12", 54000, new BigDecimal("10000.00"), TransmissionType.AUTOMATIC, 2006, model12, user11));
        OfferDTO offerDTO13 = offerService.createOffer(new OfferDTO("Description13", EngineType.DIESEL, "offerImageUrl13", 67000, new BigDecimal("16000.00"), TransmissionType.MANUAL, 2004, model13, user12));
        OfferDTO offerDTO14 = offerService.createOffer(new OfferDTO("Description14", EngineType.GASOLINE, "offerImageUrl14", 52000, new BigDecimal("10500.00"), TransmissionType.AUTOMATIC, 2002, model14, user13));
        OfferDTO offerDTO15 = offerService.createOffer(new OfferDTO("Description15", EngineType.DIESEL, "offerImageUrl15", 65000, new BigDecimal("15500.00"), TransmissionType.MANUAL, 2000, model15, user14));
        OfferDTO offerDTO16 = offerService.createOffer(new OfferDTO("Description16", EngineType.GASOLINE, "offerImageUrl16", 53000, new BigDecimal("11000.00"), TransmissionType.AUTOMATIC, 1998, model16, user15));
        OfferDTO offerDTO17 = offerService.createOffer(new OfferDTO("Description17", EngineType.DIESEL, "offerImageUrl17", 66000, new BigDecimal("16500.00"), TransmissionType.MANUAL, 1996, model17, user16));
        OfferDTO offerDTO18 = offerService.createOffer(new OfferDTO("Description18", EngineType.GASOLINE, "offerImageUrl18", 56000, new BigDecimal("10500.00"), TransmissionType.AUTOMATIC, 1994, model18, user17));
        OfferDTO offerDTO19 = offerService.createOffer(new OfferDTO("Description19", EngineType.DIESEL, "offerImageUrl19", 64000, new BigDecimal("15500.00"), TransmissionType.MANUAL, 1992, model19, user18));
        OfferDTO offerDTO20 = offerService.createOffer(new OfferDTO("Description20", EngineType.GASOLINE, "offerImageUrl20", 55000, new BigDecimal("10000.00"), TransmissionType.AUTOMATIC, 1990, model20, admin));

    }

    @Override
    public void run(String... args) throws Exception {
        createData();
//
//        // Создание и чтение CarBrand
//        BrandDTO carBrandDTO = brandService.createCarBrand("AAAAAAAAAA");
//        System.out.println("Создана марка автомобиля: " + carBrandDTO);
//
//        BrandDTO readCarBrand = brandService.getCarBrandById(carBrandDTO.getId());
//        System.out.println("Прочитана марка автомобиля: " + readCarBrand);
//
//        // Обновление CarBrand
//
//
////        // Удаление CarBrand
////        carBrandService.deleteCarBrand(carBrandDTO.getId());
////        System.out.println("Удалена марка автомобиля с ID: " + carBrandDTO.getId());
//
//        // Создание и чтение CarModel
//        BrandDTO brandDTO = brandService.createCarBrand("Toyotaaaaaaaaaaaaaaaaaaaa");
//
//        ModelDTO modelDTO = modelService.createCarModel(new ModelDTO("Camryyyyyyyyyyyyyyyyyy", ModelCategory.CAR, "imageUrl1", 1990, 2021, brandDTO.getId()));
//        System.out.println("Создана модель автомобиля с ID: " + modelDTO.getId());
//
//        ModelDTO readCarModel = modelService.getCarModelById(modelDTO.getId());
//        System.out.println("Прочитана модель автомобиля с ID: " + readCarModel.getId());
//
//        // Обновление CarModel
//
//
////        // Удаление CarModel
////        carModelService.deleteCarModel(carModelDTO.getId());
////        System.out.println("Удалена модель автомобиля с ID: " + carModelDTO.getId());
//
//        // Создание и чтение UserRole
////        UserRoleDTO userRoleDTO = userRoleService.createUserRole(new UserRoleDTO(UserRoleType.USER));
////        System.out.println("Создана роль пользователя: " + userRoleDTO);
////
////        UserRoleDTO readUserRole = userRoleService.getUserRoleById(userRoleDTO.getId());
////        System.out.println("Прочитана роль пользователя: " + readUserRole);
//
//        // Создание и чтение User
//        UserDTO userDTO = new UserDTO("Rayan", "ssssssssaaaaaa", "sas", "asa", true, "7777777777");
//        userDTO = userService.createUser(userDTO);
//        System.out.println("Создан пользователь с ID: " + userDTO.getId());
//
//        UserDTO readUser = userService.getUserByUsername(userDTO.getUsername());
//        System.out.println("Прочитан пользователь: " + readUser.getUsername());
//
//        // Обновление User
//        readUser.setLastName("Gosling");
////        userService.updateUser(readUser);
//        System.out.println("Обновлён пользователь");
//
////        // Удаление UserRole
////        userRoleService.deleteUserRole(userRoleDTO.getId());
////        System.out.println("Удалена роль пользователя с ID: " + userRoleDTO.getId());
//
////        // Удаление User
////        userService.deleteUser(userDTO.getId());
////        System.out.println("Удален пользователь с ID: " + userDTO.getId());
//
//        OfferDTO offerDTO = new OfferDTO("Description777", EngineType.GASOLINE, "offerImageUrl1", 50000, new BigDecimal("10000.00"), TransmissionType.AUTOMATIC, 2018, modelDTO.getId().toString(), userDTO.getId().toString());
//        offerDTO = offerService.createOffer(offerDTO);
//        System.out.println("Создано предложение: " + offerDTO);
//
//        OfferDTO readOffer = offerService.getOfferById(offerDTO.getId());
//        System.out.println("Прочитано предложение: " + readOffer);
//
////        // Удаление Offer
////        offerService.deleteOffer(offerDTO.getId());
////        System.out.println("Удалено предложение с ID: " + offerDTO.getId());
//
//        System.out.println("Brand Model Counts:");
//        List<BrandModelCountDTO> brandModelCounts = brandService.getBrandModelCounts();
//        for (BrandModelCountDTO brandModelCount : brandModelCounts) {
//            System.out.println("Brand: " + brandModelCount.getName());
//            System.out.println("Model Count: " + brandModelCount.getСount());
//            System.out.println("---------------");
//        }
//
//        List<OfferDetailsDTO> offerDetails = offerService.getOfferDetails();
//
//        for (OfferDetailsDTO offerDetailsDTO : offerDetails) {
//            System.out.println(offerDetailsDTO.toString());
//            System.out.println();
//        }
//
//        List<UserDTO> users = userService.findUsersByRole(UserRoleType.USER);
//        System.out.println();
//        for (UserDTO user : users) {
//            System.out.println("User ID: " + user.getId());
//            System.out.println("Username: " + user.getUsername());
//            System.out.println();
//        }
//
//        List<OfferDetailsDTO> offerDTOS = offerService.getOfferDetailsByBrandName("Mazda");
//        System.out.println();
//        for (OfferDetailsDTO offerDetailsDTO1 : offerDTOS) {
//            System.out.println(offerDetailsDTO1.toString());
//            System.out.println();
//        }
//
//        List<OfferDetailsDTO> offerDTOS2 = offerService.getOfferDetailsByStartYear(2017);
//        System.out.println();
//        for (OfferDetailsDTO offerDetailsDTO : offerDTOS2) {
//            System.out.println(offerDetailsDTO.toString());
//            System.out.println();
//        }

    }
}


package com.pristavka.patient_card.resources;

public class StreamAPI
{
    /*public List<Allergy> findAllAllergies()
    {
        List<Allergy> allergies = this.allergyServiceImp.findAll();

        String foodName = "food";

        //allergies.forEach(allergy -> log.warn(allergy.getName()));

        *//*List<Allergy> allergiesByGroup = allergies.stream()
                                                    .filter(allergy -> allergy.getGroup().equals(foodName))
                                                    .collect(Collectors.toList());
        log.warn(allergiesByGroup.toString());*//*

        *//*long count = allergies.stream()
                                .filter(allergy -> allergy.getGroup().equals(foodName))
                                .count();
        log.warn("count: " + count);*//*

        *//*List<Allergy> allergiesByGroupAndId = allergies.stream()
                                                       .filter(allergy -> allergy.getGroup().equals(foodName) &&
                                                               allergy.getId() < 100)
                                                       .collect(Collectors.toList());
        log.warn(allergiesByGroupAndId.toString());*//*

        *//*List<Allergy> allergiesByGroupAndId = allergies.stream()
                                                       .filter(allergy -> allergy.getGroup().equals(foodName))
                                                       .filter(allergy -> allergy.getId() > 100)
                                                       .collect(Collectors.toList());
        log.warn(allergiesByGroupAndId.toString());*//*

        *//*Optional<Allergy> lastAllegry = allergies.stream().skip(allergies.size() - 1).findAny();
        log.warn(lastAllegry.toString());*//*

        *//*List<Allergy> allergiesByGroupAndId = allergies.stream()
                                                       .filter(allergy -> allergy.getGroup().equals(foodName))
                                                       .limit(20)
                                                       .collect(Collectors.toList());
        log.warn(allergiesByGroupAndId.toString());*//*

       *//* List<Allergy> allergiesByGroupAndId = allergies.stream()
                                                       .skip(5)
                                                       .limit(20)
                                                       .collect(Collectors.toList());
        log.warn(allergiesByGroupAndId.toString());*//*

        *//*Optional<Allergy> allergys = allergies.stream().filter(allergy -> allergy.getName().equals("Dandelions")).findAny();
        log.warn("id - " + allergys.get().getId());*//*


        *//*List<Allergy> allergiesSortByGroup = allergies.stream()
                                                      .sorted(Comparator.comparing(Allergy::getGroup))
                                                      .collect(Collectors.toList());
        for (Allergy allergy: allergiesSortByGroup)
        {
            log.warn(allergy.toString());
        }*//*

        *//*Map<String, List<Allergy>> allergiesSortByGroup = allergies.stream()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(Allergy::getGroup,Collectors.toList()),
                        allergiesSortByGroup.values().forEach(a -> a.sort(Comparator.comparing(Allergy::getName))));*//*

        *//*Map<String, List<Allergy>> allergiesSortByGroup = allergies.stream().
                collect(Collectors.groupingBy(Allergy::getGroup,Collectors.toList()));
        allergiesSortByGroup.values().forEach(a -> a.sort(Comparator.comparing(Allergy::getName)));

        for (String key : allergiesSortByGroup.keySet())
        {
            log.warn(key + "" + allergiesSortByGroup.get(key));
        }*//*

        //return mapper.allergyToAllergyDtoList(this.allergyServiceImp.findAll());
        return this.allergyServiceImp.findAll();
    }*/
}


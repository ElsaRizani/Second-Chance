package com.example.demo.domain;

public class Dog {
    private Long id;
    private String name;
    private String breed;
    private DogStatusEnum status;

    public Dog(Long id, String name, String breed, DogStatusEnum status){
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.status = status;
    }

    public void markAsAdopted(){
        if (this.status == DogStatusEnum.ADOPTED) {
            throw new IllegalStateException("Ky qen eshte i adoptuar.");
        }
        if (this.status == DogStatusEnum.STRAY) {
            throw new IllegalStateException("Nuk mund te adoptosh nje qen endacak pa e regjistruar ne strehimore.");
        }
        this.status = DogStatusEnum.ADOPTED;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public DogStatusEnum getStatus() {
        return status;
    }

    
}

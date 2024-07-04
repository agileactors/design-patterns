package com.agileactors.builderpattern;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * User properties are indicative and split in 2 main categories:
 * 1. Mandatory: id, firstName, lastName
 * 2. Optional: age, email, permissions
 */
public class User {

  private UUID id;
  private String firstName;
  private String lastName;
  private Integer age;
  private String email;
  private List<Permission> permissions;

  /**
   * Private constructor guarantees type safety. No-one can instantiate a User object
   * outside the scope of this class.
   */
  private User() {
  }

  public UUID getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public String getEmail() {
    return email;
  }

  public List<Permission> getPermissions() {
    return permissions;
  }

  public enum Permission {
    PERMISSION1, PERMISSION2, PERMISSION3
  }

  /**
   * Director class captures the business methods of type generation (the values of the fields).
   */
  public static class Director {

    /**
     * e.g. what permissions an admin User must have
     */
    public void makeAdminUser(Builder builder) {
      reset(builder);
      builder.permissions = Stream.of(Permission.values()).toList();
    }

    public void makeBasicUser(Builder builder) {
      reset(builder);
      builder.id = UUID.randomUUID();
      builder.permissions = List.of(Permission.PERMISSION1);

      // dummy change
    }

    public void makeIntermediateUser(Builder builder) {
      reset(builder);
      builder.id = UUID.randomUUID();
      builder.permissions = List.of(Permission.PERMISSION2);
    }

    private void reset(Builder builder) {
      builder.id = null;
      builder.id = UUID.randomUUID();
      builder.permissions = null;
    }

  }

  /**
   * Builder class is just for construction, no business methods here.
   */
  public static class Builder {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private List<Permission> permissions;

    /**
     * Mandatory fields have to be part of the constructor otherwise might be missed. Either do it
     * this way or find out of the missing fields when validate methods will be invoked during the
     * construction (build method).
     *
     * <p>public Builder(UUID id, String firstName, String lastName) {
     * this.id = id;
     * this.firstName = firstName;
     * this.lastName = lastName;
     * }
     */

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder permissions(Permission... permissions) {
      this.permissions = Stream.of(permissions).toList();
      return this;
    }

    private void validate() {
      Objects.requireNonNull(id);
      Objects.requireNonNull(firstName);
      Objects.requireNonNull(lastName);
    }

    public User build() {
      var newUser = new User();
      newUser.id = id;
      newUser.age = age;
      newUser.firstName = firstName;
      newUser.lastName = lastName;
      newUser.email = email;
      newUser.permissions = permissions;

      validate();

      return newUser;
    }


  }

  @Override
  public String toString() {
    return """
        User{id='%s', \
        firstName='%s', \
        lastName='%s', \
        age=%s, \
        email='%s', \
        permissions=%s\
        }'""".formatted(id, firstName, lastName, age, email, permissions);
  }
}

package utils;

import repository.class_repo.CustomerRepository;
import repository.class_repo.EmployeeRepository;
import repository.class_repo.FacilityRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static view.Main.input;

public class CheckValueInput {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    CustomerRepository customerRepository = new CustomerRepository();

    FacilityRepository facilityRepository = new FacilityRepository();

    public boolean checkGender() {
        try {
            int inputGender;
            do {
                System.out.print("(male = 1 || female = 0): ");
                inputGender = Integer.parseInt(input.nextLine());
            } while (inputGender != 1 && inputGender != 0);
            return inputGender == 1;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkGender();
        }
    }

    public String checkIdEmployee() {
        final String ID_EMPLOYEE_REGEX = "^NV-\\d{4}$";
        boolean result;
        String regex;
        int index;
        do {
            System.out.print("- NV-XXXX (X: 0 - 9): ");
            regex = input.nextLine().trim();
            Pattern pattern = Pattern.compile(ID_EMPLOYEE_REGEX);
            Matcher matcher = pattern.matcher(regex);
            result = matcher.matches();
            index = employeeRepository.checkID(regex);
            if (index != -1) {
                System.out.println("This ID already exist!!");
            }
        } while (!result || (index != -1));
        return regex;
    }

    public String checkIdCustomer() {
        final String ID_CUSTOMER_REGEX = "^KH-\\d{4}$";
        boolean result;
        String regex;
        int index;
        do {
            System.out.print("- KH-XXXX (X: 0 - 9): ");
            regex = input.nextLine().trim();
            Pattern pattern = Pattern.compile(ID_CUSTOMER_REGEX);
            Matcher matcher = pattern.matcher(regex);
            result = matcher.matches();
            index = customerRepository.checkID(regex);
            if (index != -1) {
                System.out.println("This ID already exist!!");
            }
        } while (!result || (index != -1));
        return regex;
    }

    public String checkCodeService() {
        final String ID_SERVICE_REGEX = "^SV(VL|RO|HO)-[0-9]{4}$";
        boolean result;
        String regex;
        int index;
        do {
            System.out.print("- SVXX-YYYY (XX = Villa: VL, House: HO, Room: RO / Y: 0 - 9): ");
            regex = input.nextLine().trim();
            Pattern pattern = Pattern.compile(ID_SERVICE_REGEX);
            Matcher matcher = pattern.matcher(regex);
            result = matcher.matches();
            index = facilityRepository.checkID(regex);
            if (index != -1) {
                System.out.println("This CODE already exist!!");
            }
        } while (!result || (index != -1));
        return regex;
    }

    public String checkName() {
        final int CODE_A_UPPER_ASCII = 65;
        final int CODE_Z_UPPER_ASCII = 90;
        final int CODE_A_LOWER_ASCII = 97;
        final int CODE_Z_LOWER_ASCII = 122;
        final String NAME_REGEX = "^[A-Z].*";
        boolean result = true;
        String inputName;
        String[] array;
        do {
            System.out.print("(capitalize first letter): ");
            inputName = input.nextLine().trim();
            if (inputName.matches(NAME_REGEX)) {
                array = inputName.split(" ");
                for (String s : array) {
                    char firstChar = s.charAt(0);
                    if (firstChar <= CODE_Z_UPPER_ASCII && firstChar >= CODE_A_UPPER_ASCII) {
                        result = false;
                        for (int j = 1; j < s.length(); j++) {
                            char remainChar = s.charAt(j);
                            if (remainChar < CODE_A_LOWER_ASCII || remainChar > CODE_Z_LOWER_ASCII) {
                                result = true;
                                break;
                            }
                        }
                        if (result) {
                            break;
                        }
                    } else result = true;
                }
            }
        } while (result);
        return inputName;
    }

    public String checkBirthday() {
        boolean result = true;
        String inputBirthday;
        do {
            System.out.print("(dd/mm/yyyy): ");
            inputBirthday = input.nextLine().trim();
            if (isDateValid(inputBirthday) && is18Plus(inputBirthday)) {
                result = false;
            }
        } while (result);
        return inputBirthday;
    }

    public String checkDate() {
        boolean result = true;
        String inputDate;
        do {
            System.out.print("(dd/mm/yyyy): ");
            inputDate = input.nextLine().trim();
            if (isDateValid(inputDate)) {
                result = false;
            }
        } while (result);
        return inputDate;
    }

    public boolean isDateValid(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public boolean is18Plus(String dateStr) {
        String[] array = dateStr.split("/");
        Calendar calendar = Calendar.getInstance();
        int year = Integer.parseInt(array[2]) + 18;
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[0]);
        calendar.set(year, month, day);
        Date date = new Date();
        int compare = date.compareTo(calendar.getTime());
        return compare >= 0;
    }

    public String checkIdentityId() {
        final String IDENTITY_ID_9 = "^[0-9]{9}$";
        final String IDENTITY_ID_12 = "^[0-9]{12}$";
        boolean result = true;
        String inputIdentityId;
        do {
            System.out.print("(9 or 12 numbers): ");
            inputIdentityId = input.nextLine().trim();
            if (inputIdentityId.matches(IDENTITY_ID_9) || inputIdentityId.matches(IDENTITY_ID_12)) {
                result = false;
            }
        } while (result);
        return inputIdentityId;
    }

    public String checkPhoneNumber() {
        final String PHONE_NUMBER = "^0[0-9]{9}$";
        boolean result = true;
        String inputPhoneNumber;
        do {
            System.out.print("(start by 0 & 10 numbers): ");
            inputPhoneNumber = input.nextLine().trim();
            if (inputPhoneNumber.matches(PHONE_NUMBER)) {
                result = false;
            }
        } while (result);
        return inputPhoneNumber;
    }

    public int checkSalary() {
        try {
            boolean result = true;
            int inputSalary;
            do {
                System.out.print("(salary > 0): ");
                inputSalary = Integer.parseInt(input.nextLine().trim());
                if (inputSalary > 0) {
                    result = false;
                }
            } while (result);
            return inputSalary;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkSalary();
        }
    }

    public int checkLevel() {
        try {
            boolean result = true;
            int inputLevel;
            do {
                System.out.print("(Trung cấp = 1, Cao đẳng = 2, Đại học = 3, Sau đại học = 4): ");
                inputLevel = Integer.parseInt(input.nextLine().trim());
                if (inputLevel > 0 && inputLevel < 5) {
                    result = false;
                }
            } while (result);
            return inputLevel;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkLevel();
        }
    }

    public int checkPosition() {
        try {
            boolean result = true;
            int inputPosition;
            do {
                System.out.print("(lễ tân = 1, phục vụ = 2, chuyên viên = 3, giám sát = 4, quản lý = 5, giám đốc = 6): ");
                inputPosition = Integer.parseInt(input.nextLine().trim());
                if (inputPosition > 0 && inputPosition < 7) {
                    result = false;
                }
            } while (result);
            return inputPosition;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkPosition();
        }
    }

    public String checkEmail() {
        final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z0-9]+)$";
        final String EMAIL_2DOT_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        boolean result = true;
        String inputEmail;
        do {
            System.out.print("(a@bc.xyz / a@bc.xy.z): ");
            inputEmail = input.nextLine().trim();
            if (inputEmail.matches(EMAIL_REGEX) || inputEmail.matches(EMAIL_2DOT_REGEX)) {
                result = false;
            }
        } while (result);
        return inputEmail;
    }

    public int checkMember() {
        try {
            boolean result = true;
            int inputMember;
            do {
                System.out.print("(Diamond = 1, Platinum = 2, Gold = 3, Silver = 4, Member = 5): ");
                inputMember = Integer.parseInt(input.nextLine().trim());
                if (inputMember > 0 && inputMember < 6) {
                    result = false;
                }
            } while (result);
            return inputMember;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkMember();
        }
    }

    public double checkArea() {
        try {
            boolean result = true;
            double inputArea;
            do {
                System.out.print("(area > 30): ");
                inputArea = Double.parseDouble((input.nextLine().trim()));
                if (inputArea > 30) {
                    result = false;
                }
            } while (result);
            return inputArea;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkArea();
        }
    }

    public int checkPrice() {
        try {
            boolean result = true;
            int inputPrice;
            do {
                System.out.print("(price > 0): ");
                inputPrice = Integer.parseInt(input.nextLine().trim());
                if (inputPrice > 0) {
                    result = false;
                }
            } while (result);
            return inputPrice;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkPrice();
        }
    }

    public int checkPeople() {
        try {
            boolean result = true;
            int inputPeople;
            do {
                System.out.print("(0 < people < 20): ");
                inputPeople = Integer.parseInt(input.nextLine().trim());
                if (inputPeople > 0 && inputPeople < 20) {
                    result = false;
                }
            } while (result);
            return inputPeople;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkPeople();
        }

    }

    public int checkFloor() {
        try {
            boolean result = true;
            int inputFloor;
            do {
                System.out.print("(floor > 0): ");
                inputFloor = Integer.parseInt(input.nextLine().trim());
                if (inputFloor > 0) {
                    result = false;
                }
            } while (result);
            return inputFloor;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkFloor();
        }
    }

    public int checkStandard() {
        try {
            boolean result = true;
            int inputStandard;
            do {
                System.out.print("(Suite = 1, Deluxe = 2, Superior = 3, inputStandard = 4): ");
                inputStandard = Integer.parseInt(input.nextLine().trim());
                if (inputStandard > 0 && inputStandard < 5) {
                    result = false;
                }
            } while (result);
            return inputStandard;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkStandard();
        }
    }

    public int checkTypeOfRent() {
        try {
            boolean result = true;
            int inputType;
            do {
                System.out.print("(Hour = 1, Day = 2, Month = 3, Year = 4): ");
                inputType = Integer.parseInt(input.nextLine().trim());
                if (inputType > 0 && inputType < 5) {
                    result = false;
                }
            } while (result);
            return inputType;
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
            return checkTypeOfRent();
        }
    }
}


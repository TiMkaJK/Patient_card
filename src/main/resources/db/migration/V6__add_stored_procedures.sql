create procedure getAllergyByGroupName(in groupName VARCHAR(50))
begin
    select allergy.id,
           allergy.name
    from allergy
    where `group` = groupName;
end;

create procedure getPatientByUserId(IN userId long)
begin
    select patient.first_name,
           patient.last_name,
           patient.admission_date,
           clinic.name as clinic_name,
           patient.floor,
           patient.ward
    from patient
             join clinic on patient.clinic_id = clinic.id
    where patient.user_id = userId;
end;

create procedure getAllPatients()
begin
    select patient.id,
           patient.first_name,
           patient.last_name,
           patient.admission_date,
           clinic.id,
           patient.floor,
           patient.ward
    from patient
             join clinic on clinic.id = patient.clinic_id;
end;
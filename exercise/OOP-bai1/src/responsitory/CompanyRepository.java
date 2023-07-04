package responsitory;

import model.CanBo;
import model.CongNhan;
import model.KySu;
import model.NhanVien;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository implements ICompanyRepository {

    @Override
    public void addNew(CanBo canBo) {
        if (canBo instanceof NhanVien) {
            ReadAndWrite.writeOne(ReadAndWrite.PATH_NV, canBo);
        } else if (canBo instanceof KySu) {
            ReadAndWrite.writeOne(ReadAndWrite.PATH_KS, canBo);
        } else {
            ReadAndWrite.writeOne(ReadAndWrite.PATH_CN, canBo);
        }
    }

    @Override
    public int searchId(int id) {
        return 0;
    }

    @Override
    public CanBo getCanBo(int index) {
        return null;
    }

    @Override
    public List<CanBo> display() {
        List<CanBo> canBoList = new ArrayList<>();
        List<String> listCongNhan = ReadAndWrite.read(ReadAndWrite.PATH_CN);
        List<String> listKySu = ReadAndWrite.read(ReadAndWrite.PATH_KS);
        List<String> listNhanVien = ReadAndWrite.read(ReadAndWrite.PATH_NV);

        for (String line : listCongNhan) {
            String[] info = line.split(",");
            canBoList.add(new CongNhan(info[1], Integer.parseInt(info[2]), Boolean.parseBoolean(info[3]), info[4], Integer.parseInt(info[5])));
        }

        for (String line : listKySu) {
            String[] info = line.split(",");
            canBoList.add(new KySu(info[1], Integer.parseInt(info[2]), Boolean.parseBoolean(info[3]), info[4], info[5]));
        }

        for (String line : listNhanVien) {
            String[] info = line.split(",");
            canBoList.add(new NhanVien(info[1], Integer.parseInt(info[2]), Boolean.parseBoolean(info[3]), info[4], info[5]));
        }

        return canBoList;
    }



    @Override
    public List<CanBo> displayByName() {
        return null;
    }
}

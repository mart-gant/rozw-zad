import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional<Block> findBlockByColor(String color);
    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);
    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> blocksByMaterial = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                blocksByMaterial.add(block);
            }
        }
        return blocksByMaterial;
    }

    @Override
    public int count() {
        int i = 0;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) i = i + ((CompositeBlock) block).getBlocks().size();
            else i++;
        }
        return i;
    }
}

interface Block {
    String getColor();
    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}

//


public Optional<Block> findBlockByColor(String color) {
    for (Block block : blocks) {
        if (block.getColor().equals(color)) {
            return Optional.of(block);
        }
    }
    return Optional.empty();
}


package org.example.snackScript.compiler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.snackScript.ast.Declaration;
import org.example.snackScript.vm.Blob;
import org.example.snackScript.vm.UpvalueMapEntry;

import java.util.IdentityHashMap;

@RequiredArgsConstructor
@Getter
public class InTranslationBlob {
    private final Blob code;
    private final IdentityHashMap<Declaration, Integer> localSlots;

    public record UpvalSlotInfo(int slotNr, UpvalueMapEntry entry) {}
    private final IdentityHashMap<Declaration, UpvalSlotInfo> upvalSlots;
    private final InTranslationBlob previousBlob;
    private int localDepth = 0;
    private int maxLocalDepth = 0;

    public void setLocalDepth(int localDepth) {
        if ((this.localDepth = localDepth) > maxLocalDepth)
            maxLocalDepth = localDepth;
    }
}

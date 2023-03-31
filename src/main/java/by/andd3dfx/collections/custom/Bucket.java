package by.andd3dfx.collections.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bucket<K, V> {

    private CustomEntry<K, V> head;
}
